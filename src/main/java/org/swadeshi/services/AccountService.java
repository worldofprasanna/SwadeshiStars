package org.swadeshi.services;

import org.springframework.data.repository.CrudRepository;
import org.swadeshi.entities.Account;

public interface AccountService extends CrudRepository<Account, String> {

}
