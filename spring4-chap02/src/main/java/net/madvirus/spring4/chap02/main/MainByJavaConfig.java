package net.madvirus.spring4.chap02.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.madvirus.spring4.chap02.AuthenticationService;
import net.madvirus.spring4.chap02.PasswordChangeService;
import net.madvirus.spring4.chap02.conf.Config;
import net.madvirus.spring4.chap02.conf.Config1;
import net.madvirus.spring4.chap02.conf.Config2;

public class MainByJavaConfig {
	
	public static void main(String[] args) {
		useSingleClass();
		useMultipleClass();
	}

	private static void useSingleClass() {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(Config.class);
		useBean(context);
		context.close();
	}

	private static void useMultipleClass() {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(Config1.class, Config2.class); //두 개 이상의 설정 정보를 사용할 때
		useBean(context);
		context.close();
	}

	private static void useBean(AnnotationConfigApplicationContext context) {
		AuthenticationService authService = 
				context.getBean("authenticationService", AuthenticationService.class);
		authService.authenticate("bkchoi", "1234");
		
		PasswordChangeService passwordChangeService =
				context.getBean(PasswordChangeService.class);
		passwordChangeService.changePassword("bkchoi", "1234", "5678");
	}
	
}
