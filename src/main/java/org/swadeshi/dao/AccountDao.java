package org.swadeshi.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.swadeshi.entities.Account;

@Repository
public interface AccountDao extends CrudRepository<Account, String> {

}
