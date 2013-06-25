/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.swadeshi.controllers;

import java.security.Principal;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.google.api.Google;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.swadeshi.entities.Appreciation;
import org.swadeshi.entities.User;
import org.swadeshi.entities.UserConnection;
import org.swadeshi.exceptions.CustomException;
import org.swadeshi.services.AppreciationService;
import org.swadeshi.services.UserService;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private Google google;
	
	@Autowired
	private Facebook facebook;
	
	@Autowired
	private Twitter twitter;
	
	@Autowired
	private AppreciationService appreciationService;

	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value={"/activities","/"})
	public ModelAndView activitiesList(Principal currentUser, HttpServletRequest request, Pageable page){
		
		ModelAndView modelAndView = new ModelAndView("activities");
		return modelAndView;
		
	}
	
	@RequestMapping(value={"/accounts"})
	public ModelAndView accountsList(Principal currentUser, HttpServletRequest request, Pageable page){
		
		ModelAndView modelAndView = new ModelAndView("appreciation");
		return modelAndView;
		
	}
	
	
	
	@RequestMapping(value={"/appreciation"})
	public ModelAndView appreciationList(Principal currentUser, HttpServletRequest request, Pageable page){
		
		String userName = this.getUserName();
		ModelAndView modelAndView =new ModelAndView("appreciation");
		
		try {
			Page<Appreciation> appreciations = appreciationService.fetchAllAppreciations(page);
			modelAndView.addObject("page", appreciations);
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		modelAndView.addObject("username", userName);
		return modelAndView;
		
	}
	
	@RequestMapping(value={"/users"})
	public ModelAndView usersList(Principal currentUser, HttpServletRequest request, Pageable page){
		ModelAndView modelAndView = new ModelAndView("users");
		
		String userName = this.getUserName();
		modelAndView.addObject("username", userName);
		
		Page<User> users = userService.fetchAllUsers(page);
		modelAndView.getModel().put("page", users);
		return modelAndView;
	}
	
	//activities
	
	@RequestMapping(value={"/activities"})
	public ModelAndView activityList(Principal currentUser, HttpServletRequest request, Pageable page){
		ModelAndView modelAndView = new ModelAndView("activities");
		
		String userName = this.getUserName();
		modelAndView.addObject("username", userName);
		
		Page<User> users = userService.fetchAllUsers(page);
		modelAndView.getModel().put("page", users);
		return modelAndView;
	}

	private String getUserName(){
		String userName="Guest";
		if (google.isAuthorized())
				userName = google.userOperations().getUserProfile().getName();
		if (facebook.isAuthorized())
			userName = facebook.userOperations().getUserProfile().getName();
		
		if (twitter.isAuthorized())
			userName = twitter.userOperations().getUserProfile().getName();
		return userName;
	}
	
	
}
