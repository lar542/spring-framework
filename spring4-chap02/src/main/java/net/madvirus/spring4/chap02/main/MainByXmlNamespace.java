package net.madvirus.spring4.chap02.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import net.madvirus.spring4.chap02.AuthenticationService;
import net.madvirus.spring4.chap02.PasswordChangeService;

/**
 * c 네임스페이스와 p 네임스페이스를 생성자 방식과 프로퍼티 방식으로 설정 
 */
public class MainByXmlNamespace {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:config-with-*.xml");
		AuthenticationService authSvc = ctx.getBean("authenticationService", AuthenticationService.class);
		authSvc.authenticate("user1", "1234");
		PasswordChangeService pwChgSvc = ctx.getBean(PasswordChangeService.class);
		pwChgSvc.changePassword("user1", "1234", "5678");
		authSvc.authenticate("user1", "5678");
		ctx.close();
	}
}
