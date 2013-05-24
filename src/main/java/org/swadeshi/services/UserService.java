package org.swadeshi.services;

import org.springframework.data.repository.CrudRepository;
import org.swadeshi.entities.User;

public interface UserService extends CrudRepository<User, String> {

}
