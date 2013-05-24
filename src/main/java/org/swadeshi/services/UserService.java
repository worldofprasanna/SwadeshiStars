package org.swadeshi.services;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.swadeshi.entities.User;

@Repository
public interface UserService extends CrudRepository<User, String> {

}
