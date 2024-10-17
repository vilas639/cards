package com.eazybytes.cards.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eazybytes.cards.constants.AccountsConstants;
import com.eazybytes.cards.dto.CustomerDto;
import com.eazybytes.cards.dto.ResponseDto;
import com.eazybytes.cards.service.IAccountsService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping(path="/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class AccountsController {
	
	
	@Autowired
	IAccountsService iAccountsService;
	
	@GetMapping("hello")
	public String hi()
	{
		return "say hi";
	}

	
	 @PostMapping("/create")
	    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto) {
	        iAccountsService.createAccount(customerDto);
	       
	        return ResponseEntity
	                .status(HttpStatus.CREATED)
	                .body(new ResponseDto(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
	    }
	 
	 @GetMapping("/fetch")
	    public ResponseEntity<CustomerDto> fetchAccountDetails(@RequestParam String mobileNumber) {
	        CustomerDto customerDto = iAccountsService.fetchAccount(mobileNumber);
	        return ResponseEntity.status(HttpStatus.OK).body(customerDto);
	    }
	
}
