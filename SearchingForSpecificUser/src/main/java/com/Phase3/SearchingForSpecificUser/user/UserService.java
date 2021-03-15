package com.Phase3.SearchingForSpecificUser.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public Optional<UserEntity> getUser(String userID) {
		return userRepository.findById(userID);
	}
	
	public List<UserEntity> getAllUsers() {
		return userRepository.findAll();
	}
	
	public boolean insertUser(UserEntity user) {
		try {
			userRepository.save(user);
			return true;
		} catch(IllegalArgumentException e) {
			return false;
		}
		
	}
	
}
