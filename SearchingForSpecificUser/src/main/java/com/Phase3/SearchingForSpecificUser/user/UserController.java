package com.Phase3.SearchingForSpecificUser.user;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;

	@RequestMapping("/users/{userID}")
	public Optional<UserEntity> getUser(@PathVariable String userID) {
		return userService.getUser(userID);
	}

	@RequestMapping("/users")
	public ModelAndView getAllUsers() {
		ModelAndView mv = new ModelAndView();
		userService.getAllUsers();
		mv.setViewName("users");
		return mv;
	}

	@RequestMapping(method=RequestMethod.POST, value="/edit")
	public ModelAndView insertUser(@ModelAttribute("user") UserEntity user) {
		logger.info("Attempting  to add user: " + user);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("edit");
		if(userService.insertUser(user)) {
			mv.addObject("result", "Successfully updated " + user.getUserID());
		} else  {
			mv.addObject("result", "Unable to update " + user.getUserID());
		}
		return mv;		
	}

	@RequestMapping(method = RequestMethod.POST, value = "/users")
	public ModelAndView validateUser(@RequestParam String userID) {
		logger.info("validating user");
		ModelAndView mv = new ModelAndView();
		Optional<UserEntity> user = userService.getUser(userID);
		if (user.isPresent()) {
			mv.addObject("user", user.get());
			mv.setViewName("edit");
		} else {
			mv.addObject("result", "User does not exist");
			mv.setViewName("users");
		}
		return mv;
	}
}
