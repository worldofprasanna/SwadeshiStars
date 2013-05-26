package org.swadeshi.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.swadeshi.dao.AccountDao;
import org.swadeshi.entities.Account;
import org.swadeshi.entities.Appreciation;
import org.swadeshi.entities.User;
import org.swadeshi.exceptions.CustomException;

@Service
public class AccountService {

	@Autowired
	private AccountDao accountDao;
	
	@Autowired
	private UserService userService;
	
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
	
	@Transactional
	public List<Account> contributedAccounts(List<String> userNameList, List<Double> amountList) throws CustomException{
		
		Calendar calendar = Calendar.getInstance();
		int month = calendar.get(Calendar.MONTH);
		int year = calendar.get(Calendar.YEAR);
		String monthYear = month+"/"+year;
		Iterator<String> userNameIterator = userNameList.iterator();
		Iterator<Double> amountListIterator = amountList.iterator();
		while (userNameIterator.hasNext() && amountListIterator.hasNext()){
			String userName = userNameIterator.next();
			Double amount = amountListIterator.next();
			User user = userService.findUserByUserName(userName);
			Account account = new Account();
			account.setUser(user);
			account.setAmount(amount);
			account.setMonthYear(monthYear);
			this.saveAccount(account);			
		}
		
		if (userNameIterator.hasNext() || amountListIterator.hasNext()){
			throw new CustomException("Mismatch in No of Users & No of amount entered.", "BUSINESS_CRITICAL");
		}
		
		List<Account> accounts = accountDao.findAccountByMonthYear(monthYear);
		return accounts;
	}
	
}
