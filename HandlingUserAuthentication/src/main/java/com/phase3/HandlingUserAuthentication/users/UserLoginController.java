package com.phase3.HandlingUserAuthentication.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserLoginController {
	
	@Autowired UserAuthenticationService service;
	
	@RequestMapping("/Login")
	public ModelAndView defaultView() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Login");
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/Login")
	public ModelAndView login(@RequestParam String userId, @RequestParam String password) {
		ModelAndView mv = new ModelAndView();
		String result = "";
		mv.setViewName("Login");
		switch(service.authenticate(userId, password)) {
		case 1: 
			result = "Invalid user id";
			break;
		case 2: 
			result = "Invalid password";
			break;
		case 3: 
			result = "Valid login";
			break;
		}
		
		mv.addObject("result", result);
		return mv;
	}
}
