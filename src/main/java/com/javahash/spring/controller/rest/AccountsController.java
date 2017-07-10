package com.javahash.spring.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javahash.spring.model.Account;
import com.javahash.spring.service.IAccountsService;

//@Controller
@RequestMapping( value = "/accounts" )
public class AccountsController implements CrudController<Account> {
	
	
	@Autowired
	IAccountsService accountsService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Account> findAll() {
		return accountsService.findAll();
	}

	public Account findOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Account create(Account resource) {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(String id, Account resource) {
		// TODO Auto-generated method stub
		
	}

	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}	

}
