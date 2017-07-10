package com.javahash.spring.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.javahash.spring.model.Account;
import com.javahash.spring.model.AccountType;
import com.javahash.spring.service.IAccountsService;

public class AccountsServiceImpl implements IAccountsService{

	public List<Account> findAll() {
		List<Account> accounts = new ArrayList<Account>();
		Account ac1 = new Account();
		ac1.setId("54321");
		AccountType accType = new AccountType();
		accType.setId("3");
		ac1.setAccountType(accType);
		accounts.add(ac1);
		
		Account ac2 = new Account();
		ac2.setId("54324");
		AccountType accType2 = new AccountType();
		accType2.setId("3");
		ac2.setAccountType(accType2);
		accounts.add(ac2);
		
		return accounts;
	}

}
