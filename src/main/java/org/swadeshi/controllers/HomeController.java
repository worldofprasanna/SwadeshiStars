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

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	
	@RequestMapping("/home")
	public ModelAndView test(Principal currentUser){
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println("User : "+userName);
		ModelAndView modelAndView =new ModelAndView("home");
		modelAndView.addObject("username", userName);
		return modelAndView;
		
	}

	@RequestMapping("/signin")
	public String home(Principal currentUser, Model model, HttpServletRequest request) {
		String errorValue = request.getParameter("error");
		return "signin";
	}
	
	
}
