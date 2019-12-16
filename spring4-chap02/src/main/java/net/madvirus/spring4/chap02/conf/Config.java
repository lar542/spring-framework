package net.madvirus.spring4.chap02.conf;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.madvirus.spring4.chap02.AuthFailLogger;
import net.madvirus.spring4.chap02.AuthenticationService;
import net.madvirus.spring4.chap02.PasswordChangeService;
import net.madvirus.spring4.chap02.User;
import net.madvirus.spring4.chap02.UserRepository;

/**
 * 자바코드로 DI 설정
 * @Configuration 과 @Bean 을 사용함으로써 자바 코드로 스프링 설정 정보를 작성함을 알림 
 */
@Configuration //이 클래스를 스프링 설정으로 사용한다
public class Config {

	@Bean //메서드의 리턴 값을 빈 객체로 사용한다
	public User user1() { //메서드 이름을 빈 객체의 식별자로 사용
		return new User("bkchoi", "1234");
	}
	
	@Bean(name = "user2") //빈 객체의 식별 값을 name 속성으로 설정
	public User user() {
		return new User("madvirus", "qwer");
	}
	
	//다른 빈 객체를 참조할 때는 참조할 빈 객체를 생성하는 메서드를 호출
	@Bean
	public UserRepository userRepository() {
		UserRepository userRepository = new UserRepository();
		userRepository.setUsers(Arrays.asList(user1(), user()));
		return userRepository;
	}
	
	@Bean
	public PasswordChangeService passwordChangeService() {
		return new PasswordChangeService(userRepository());
	}
	
	@Bean
	public AuthFailLogger authFailLogger() {
		AuthFailLogger logger = new AuthFailLogger();
		logger.setThreshold(2);
		return logger;
	}
	
	@Bean
	public AuthenticationService authenticationService() {
		AuthenticationService authenticationService = new AuthenticationService();
		authenticationService.setFailLogger(authFailLogger());
		authenticationService.setUserRepository(userRepository());
		return authenticationService;
	}
}
