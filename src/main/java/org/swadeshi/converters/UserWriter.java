package org.swadeshi.converters;

import org.springframework.core.convert.converter.Converter;
import org.swadeshi.model.User;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class UserWriter implements Converter<User, DBObject>{
	
	public DBObject convert(User user) {
		DBObject dbo = new BasicDBObject();
		dbo.put("_id", user.getEmailId());
		dbo.put("userName",  user.getUserName());
		return dbo;
	}

}