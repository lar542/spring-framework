package net.madvirus.spring4.chap02.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import net.madvirus.spring4.chap02.AuthException;
import net.madvirus.spring4.chap02.AuthInfo;
import net.madvirus.spring4.chap02.AuthenticationService;
import net.madvirus.spring4.chap02.PasswordChangeService;
import net.madvirus.spring4.chap02.UserNotFoundException;

public class MainByXml {

	public static void main(String[] args) {
		//설정 파일을 이용해 스프링 컨테이너를 코드에서 직접 생성
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:config.xml");
		AuthenticationService authService = context.getBean("authenticationService", AuthenticationService.class);
		runAuthAndCatchAuthEx(authService, "user1", "1111");
		runAuthAndCatchAuthEx(authService, "user1", "11111");
		runAuthAndCatchAuthEx(authService, "user1", "111111");
		try {
			authService.authenticate("user4", "user4");
		} catch (UserNotFoundException ex) {
			System.out.println("존재하지 않는 계정");
		}
		runAuthAndCatchAuthEx(authService, "user1", "user1_password");
		PasswordChangeService pwChgSvc = context.getBean(PasswordChangeService.class);
		pwChgSvc.changePassword("user1", "user1_password", "user1_new_pw");
		runAuthAndCatchAuthEx(authService, "user1", "user1_password");
		runAuthAndCatchAuthEx(authService, "user1", "user1_new_pw");
		context.close();
	}

	private static void runAuthAndCatchAuthEx(AuthenticationService authService, String userId, String password) {
		try {
			AuthInfo authInfo = authService.authenticate(userId, password);
			System.out.println("계정 " + authInfo.getId() + " 인증 성공");
		} catch (AuthException e) {
		}
	}
}
