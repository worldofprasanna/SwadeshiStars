package org.swadeshi.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.swadeshi.dao.UserDao;
import org.swadeshi.entities.Account;
import org.swadeshi.entities.User;
import org.swadeshi.entities.UserConnection;
import org.swadeshi.exceptions.CustomException;

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
	
	public User saveUser(User user){
		return userDao.save(user);
	}
	
	public User findUserByUserName(String userName) throws CustomException{
		return userDao.findUserByUserName(userName);
	}
	
	public Page<User> fetchAllUsers(Pageable page){
		Page<User> users = userDao.findAll(page);		
		return users;
	}
}
