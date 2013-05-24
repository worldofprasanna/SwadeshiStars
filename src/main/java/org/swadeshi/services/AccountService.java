package org.swadeshi.services;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.swadeshi.entities.Account;

@Repository
public interface AccountService extends CrudRepository<Account, String> {

}
