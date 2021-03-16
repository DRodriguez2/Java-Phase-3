package com.phase3.DisplayingUserFeedback.feedback;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FeedbackService {
	
	@Autowired
	private FeedbackRepository repository;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	public Iterable<Feedback> getAllFeedback() {
		return repository.findAll();
	}
	
	public Optional<Feedback> getFeedback(int id) {
		return repository.findById(id);
	}
	
	public boolean insertFeedback(Feedback feedback) {
		try {
			repository.save(feedback);
			return true;
		} catch(IllegalArgumentException e) {
			return false;
		}	
	}
}
