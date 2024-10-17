package com.eazybytes.cards.service;

import com.eazybytes.cards.dto.CustomerDto;

public interface IAccountsService {

	 void createAccount(CustomerDto customerDto);

	    
	    CustomerDto fetchAccount(String mobileNumber);
//
//	   
//	    boolean updateAccount(CustomerDto customerDto);
//
//	   
//	    boolean deleteAccount(String mobileNumber);

}
