package org.swadeshi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.swadeshi.dao.UserDao;
import org.swadeshi.entities.User;

@RequestMapping("/user")
@Controller
public class UserController {

	@Autowired private UserDao userService;
	
	@RequestMapping(value = "/allUsers", method = RequestMethod.GET)
	public ModelAndView getAllMembers() {
		ModelAndView view = new ModelAndView("usersList");
		Iterable<User> usersList =  userService.findAll();
		view.addObject("usersList", usersList);
		return view;
	}
	
}
