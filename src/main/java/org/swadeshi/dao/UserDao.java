package org.swadeshi.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.swadeshi.entities.User;
import org.swadeshi.entities.UserConnection;

@Repository
public interface UserDao extends CrudRepository<User, String> {
	
	public User findUserByUserName(String userName);
	
	public Page<User> findAll(Pageable page);
	
}
