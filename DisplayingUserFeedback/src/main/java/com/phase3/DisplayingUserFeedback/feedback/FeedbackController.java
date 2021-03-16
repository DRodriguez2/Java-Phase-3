package com.phase3.DisplayingUserFeedback.feedback;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class FeedbackController {
	
	@Autowired
	private FeedbackService service;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/feedback")
	public ModelAndView defaultView() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("feedback");
		return mv;
	}
	
	@RequestMapping("/getAllFeedback")
	public Iterable<Feedback> getAllFeedback() {
		return service.getAllFeedback();
	}
	
	@RequestMapping("/feedback/{id}")
	public Optional<Feedback> getFeedback(@PathVariable int id)  {
		return service.getFeedback(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/feedback")
	public ModelAndView insertFeedback(@RequestParam String feedback) {
		ModelAndView mv = new ModelAndView();
		logger.info(feedback);
		Feedback userFeedback = new Feedback(feedback);
		if(service.insertFeedback(userFeedback)) 
			mv.addObject("result", "Successfully submitted feedback, thank you");
		else
			mv.addObject("result", "Unable to submit user feedback");
		
		mv.setViewName("feedback");
		return mv;
	}
	
}
