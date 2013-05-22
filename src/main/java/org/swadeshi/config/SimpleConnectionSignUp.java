package org.swadeshi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UserProfile;
import org.swadeshi.user.User;

public class SimpleConnectionSignUp implements ConnectionSignUp {

	@Autowired private MongoTemplate mongoTemplate;
	
	public String execute(Connection<?> connection) {
		// TODO Auto-generated method stub
		
		System.out.println(connection.getDisplayName());
		UserProfile profile = connection.fetchUserProfile();
		User user = new User();
		user.setEmailId(profile.getEmail());
		user.setFirstName(profile.getFirstName());
		user.setLastName(profile.getLastName());
		user.setUserName(profile.getUsername());
		mongoTemplate.save(user);
		return profile.getUsername();
	}

}
