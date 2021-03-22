package com.phase3.HandlingUserAuthentication;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.phase3.HandlingUserAuthentication.users.User;
import com.phase3.HandlingUserAuthentication.users.UserAuthenticationService;

@SpringBootTest
class UserAuthenticationServiceTests {

	@Autowired UserAuthenticationService service;

	@Autowired EntityManager em;
	
	@BeforeEach
	void addUser() {
		User user = new User("1", "password");
		em.persist(user);
		em.flush();
	}
	
	@Test
	@Transactional
	void validLogin() {	
		assertEquals(3, service.authenticate("1", "password"));
	}
	
	@Test
	@Transactional
	void invalidPassword() {
		assertEquals(2, service.authenticate("1", "invalid"));
	}
	
	@Test
	@Transactional
	void invalidUserId() {
		assertEquals(1, service.authenticate("invalid", "password"));
	}
	
	

	

}
