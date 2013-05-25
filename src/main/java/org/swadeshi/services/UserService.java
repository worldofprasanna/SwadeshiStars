package org.swadeshi.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.swadeshi.dao.UserDao;
import org.swadeshi.entities.Account;
import org.swadeshi.entities.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public List<User> fetchAllUsers(){
		Iterable<User> userIterable = userDao.findAll();
		Iterator<User> userIterator = userIterable.iterator();
		List<User> users = new ArrayList<User>();
		while (userIterator.hasNext())
			users.add(userIterator.next());
		return users;
	}
	
	public User saveAccount(User user){
		return userDao.save(user);
	}
}
