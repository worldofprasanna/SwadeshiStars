package org.swadeshi.converters;

import org.springframework.core.convert.converter.Converter;
import org.swadeshi.model.User;

import com.mongodb.DBObject;

public class UserReader implements Converter<DBObject, User>{

	public User convert(DBObject source) {
		User user = new User();
		user.setEmailId((String) source.get("email"));
		user.setUserName((String) source.get("name"));
		return user;
	}

}
