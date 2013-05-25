package org.swadeshi.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.swadeshi.dao.AccountDao;
import org.swadeshi.entities.Account;
import org.swadeshi.entities.Appreciation;
import org.swadeshi.exceptions.CustomException;

@Service
public class AccountService {

	@Autowired
	private AccountDao accountDao;
	
	public List<Account> fetchAllAccounts() throws CustomException{
		Iterable<Account> accountIterable = accountDao.findAll();
		Iterator<Account> accountIterator = accountIterable.iterator();
		List<Account> accounts = new ArrayList<Account>();
		while (accountIterator.hasNext())
			accounts.add(accountIterator.next());
		return accounts;
	}
	
	public Account saveAccount(Account account) throws CustomException{
		return accountDao.save(account);
	}
}
