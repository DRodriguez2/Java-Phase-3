package com.phase3.HandlingUserAuthentication;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.phase3.HandlingUserAuthentication.users.User;
import com.phase3.HandlingUserAuthentication.users.UserRepository;

@DataJpaTest
class UserRepositoryTests {

	@Autowired
	UserRepository repository;
	
	@Autowired
	EntityManager em;
	
	@Test
	void findById() {
		User user = new User("1", "password");
		em.persist(user);
		em.flush();
		Optional<User> found = repository.findById("1");
		assertEquals(found.get().getUserID(), user.getUserID());	
	}

}
