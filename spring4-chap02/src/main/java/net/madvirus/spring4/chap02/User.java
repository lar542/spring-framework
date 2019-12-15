package net.madvirus.spring4.chap02;

/**
 * 사용자 정보 보관
 * 암호 일치 여부, 암호 변경 기능
 */
public class User {

	private String id;
	private String password;
	
	public User(String id, String password) {
		this.id = id;
		this.password = password;
	}
	
	public String getId() {
		return id;
	}
	
	public boolean matchPassword(String inputPasswd) {
		return password.equals(inputPasswd);
	}
	
	public void changePassword(String oldPassword, String newPassword) {
		if (!matchPassword(oldPassword)) {
			throw new IllegalArgumentException("illegal password");
		}
		password = newPassword;
	}
}
