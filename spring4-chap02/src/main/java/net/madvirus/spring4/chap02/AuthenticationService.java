package net.madvirus.spring4.chap02;

/**
 * 아이디/암호를 입력받아 인증 수행
 * 암호 일치 여부 확인 후 실패하면 실패 기록을 남김 
 */
public class AuthenticationService {

	private UserRepository userRepository;
	private AuthFailLogger failLogger;
	
	public AuthInfo authenticate(String id, String password) {
		User user = userRepository.findUserById(id);
		
		if (user == null)
			throw new UserNotFoundException();
		
		if (!user.matchPassword(password)) {
			failLogger.insertBadPw(id, password);
			throw new AuthException();
		}
		
		return new AuthInfo(user.getId());
	}
	
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	public void setFailLogger(AuthFailLogger failLogger) {
		this.failLogger = failLogger;
	}
}
