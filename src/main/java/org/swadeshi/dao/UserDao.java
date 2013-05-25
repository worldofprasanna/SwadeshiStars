package org.swadeshi.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.swadeshi.entities.User;

@Repository
public interface UserDao extends CrudRepository<User, String> {

}
