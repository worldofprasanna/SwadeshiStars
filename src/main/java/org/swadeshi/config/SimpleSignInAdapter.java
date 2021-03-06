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
package org.swadeshi.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.web.context.request.NativeWebRequest;
import org.swadeshi.entities.User;
import org.swadeshi.exceptions.CustomException;
import org.swadeshi.services.UserService;

public class SimpleSignInAdapter implements SignInAdapter {
	
	@Autowired private UserService userService;

	public String signIn(String localUserId, Connection<?> connection, NativeWebRequest request) {
		signin(connection.fetchUserProfile().getUsername());
		return "/home/";
	}

	public void signin(String userId) {
		User user = null;
		String roleName = "ROLE_USER";
		try {
			user = userService.findUserByUserName(userId);
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (user != null && user.getRoleName() != null) {
			roleName = user.getRoleName();
		}
		List<GrantedAuthority> auth= new ArrayList<GrantedAuthority>();
		auth.add(new GrantedAuthorityImpl(roleName));
		SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(userId, null, auth));	
	}


}
