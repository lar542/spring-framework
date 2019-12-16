package net.madvirus.spring4.chap02.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.madvirus.spring4.chap02.AuthFailLogger;
import net.madvirus.spring4.chap02.AuthenticationService;
import net.madvirus.spring4.chap02.PasswordChangeService;
import net.madvirus.spring4.chap02.UserRepository;

@Configuration
public class Config1 {

	@Autowired
	private UserRepository userRepository;
	
	@Bean
	public PasswordChangeService passwordChangeService() {
		return new PasswordChangeService(userRepository);
	}
	
	@Bean
	public AuthFailLogger authFailLogger() {
		AuthFailLogger logger = new AuthFailLogger();
		logger.setThreshold(2);
		return logger;
	}
	
	@Bean
	public AuthenticationService authenticationService() {
		AuthenticationService authService = new AuthenticationService();
		authService.setFailLogger(authFailLogger());
		authService.setUserRepository(userRepository);
		return authService;
	}
}
