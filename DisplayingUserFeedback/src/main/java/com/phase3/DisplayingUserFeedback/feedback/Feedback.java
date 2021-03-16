package com.phase3.DisplayingUserFeedback.feedback;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;




@Entity
public class Feedback {
	
	@Id
	@GeneratedValue
	private int id;
	private String feedback;
	
	public Feedback() {
		
	}
	
	public Feedback(String feedback) {
		this.feedback = feedback;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	@Override
	public String toString() {
		return "Feedback [id=" + id + ", feedback=" + feedback + "]";
	}
}
