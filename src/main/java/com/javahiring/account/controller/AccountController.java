package com.javahiring.account.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javahiring.account.common.Account;
import com.javahiring.account.common.AccountCreditDebitRequest;
import com.javahiring.account.common.StatusVO;
import com.javahiring.account.service.AccountService;
import com.javahiring.account.validation.AccountValidator;

@RestController
@RequestMapping("/account/*")
public class AccountController extends InternalExceptionHandler{
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AccountService accountService;
	@Autowired
	private AccountValidator accountValidator;
	
	@RequestMapping(value = "create", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Account createAccount(@RequestBody Account account,HttpServletRequest request, HttpServletResponse response) {
    	logger.info("Enter into Create Account for userId: "+account.getUserId());
    	accountValidator.validateCreateAccountRequest(account);
    	try {
    		return accountService.createAccount(account);
    	} catch(Exception e) {
    		throw new ApiException(e, null);
    	}
    }
	
	@RequestMapping(value = "credit", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public StatusVO creditMoney(@RequestBody AccountCreditDebitRequest account,HttpServletRequest request, HttpServletResponse response) {
    	logger.info("Enter into CreditDebit Account for userId: "+account.getUserId());
    	accountValidator.validateAccountDebitCredit(account);
    	try {
    		return accountService.addMoneyToAccount(account.getUserId(),account.getAmount());
    	} catch(Exception e) {
    		throw new ApiException(e, null);
    	}
    }
	
	@RequestMapping(value = "debit", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public StatusVO debitMoney(@RequestBody AccountCreditDebitRequest account,HttpServletRequest request, HttpServletResponse response) {
    	logger.info("Enter into CreditDebit Account for userId: "+account.getUserId());
    	accountValidator.validateAccountDebitCredit(account);
    	try {
    		return accountService.deductMoneyFromAccount(account.getUserId(),account.getAmount());
    	} catch(Exception e) {
    		throw new ApiException(e, null);
    	}
    }
	
	@RequestMapping(value = "get", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Account getAccount(@RequestParam Integer userId,HttpServletRequest request, HttpServletResponse response) {
    	logger.info("Enter into get Account for userId: "+userId);
    	accountValidator.validateGetAccount(userId);
    	try {
    		return accountService.getBalance(userId);
    	} catch(Exception e) {
    		throw new ApiException(e, null);
    	}
    }
}
