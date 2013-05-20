package org.swadeshi.repository;

import org.springframework.data.repository.Repository;
import org.swadeshi.model.User;

public interface UserService extends Repository<User, Long> {

}
