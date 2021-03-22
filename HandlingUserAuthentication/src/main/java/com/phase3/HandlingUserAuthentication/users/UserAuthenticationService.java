package com.phase3.HandlingUserAuthentication.users;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAuthenticationService {

	@Autowired private UserRepository userRepository;
	
	/**
	 * Returns 1 if user does not exist, 2 if password is invalid, and 3 if login is valid. 
	 * @param userId
	 * @param password
	 * @return
	 */
	public int authenticate(String userId, String password) {
		Optional<User> user;
		if((user = userRepository.findById(userId)).isPresent()) {
			return (password.equals(user.get().getPassword())) ? 3:2;
		}
		else return 1;
	}
}
