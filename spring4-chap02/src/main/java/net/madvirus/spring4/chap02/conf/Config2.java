package net.madvirus.spring4.chap02.conf;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.madvirus.spring4.chap02.User;
import net.madvirus.spring4.chap02.UserRepository;

@Configuration
public class Config2 {

	@Bean
	public User user1() {
		return new User("bkchoi", "1234");
	}
	
	@Bean(name = "user2")
	public User user() {
		return new User("madvirus", "qwer");
	}
	
	@Bean
	public UserRepository userRepository() {
		UserRepository userRepository = new UserRepository();
		userRepository.setUsers(Arrays.asList(user1(), user()));
		return userRepository;
	}
}
