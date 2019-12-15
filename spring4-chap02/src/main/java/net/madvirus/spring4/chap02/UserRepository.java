package net.madvirus.spring4.chap02;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User 객체 보관
 * ID를 이용해서 User 객체를 찾는 기능 
 */
public class UserRepository {

	private Map<String, User> userMap = new HashMap<String, User>();
	
	public User findUserById(String id) {
		return userMap.get(id);
	}
	
	public void setUsers(List<User> users) {
		for(User u : users) {
			userMap.put(u.getId(), u);
		}
	}
}
