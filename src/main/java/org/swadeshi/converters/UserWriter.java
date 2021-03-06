package org.swadeshi.converters;

import org.springframework.core.convert.converter.Converter;
import org.swadeshi.entities.User;
import org.swadeshi.entities.UserConnection;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class UserWriter implements Converter<User, DBObject>{
	
	public DBObject convert(User user) {
		DBObject dbo = new BasicDBObject();
		//dbo.put("_id", user.getEmailId());
		dbo.put("userName",  user.getUserName());
		dbo.put("firstName",  user.getFirstName());
		dbo.put("lastName",  user.getLastName());
		dbo.put("emailId",  user.getEmailId());
		dbo.put("displayName",  user.getDisplayName());
		return dbo;
	}

}