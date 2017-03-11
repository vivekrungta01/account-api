package com.javahiring.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javahiring.account.common.Account;
import com.javahiring.account.common.ErrorCode;
import com.javahiring.account.common.StatusVO;
import com.javahiring.account.controller.InternalExceptionHandler;
import com.javahiring.account.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Transactional
	public Account createAccount(Account account) {
		if(account.getBalance()==null)
			account.setBalance(0.0);
		return accountRepository.save(account);
	}

	@Transactional
	public StatusVO addMoneyToAccount(Integer userId, double money) {
		Account account=accountRepository.findByUserId(userId);
		if(account==null) {
			throw new InternalExceptionHandler.ApiValidationException(ErrorCode.ER_1003,ErrorCode.ER_1003.getMessage());
		} 
		try {
			accountRepository.creditBalance(userId, money);
			return new StatusVO(true);
		} catch(Exception e) {
			throw new InternalExceptionHandler.ApiException(e,null);
		}
	}

	@Transactional
	public StatusVO deductMoneyFromAccount(Integer userId, double money) {
		Account account=accountRepository.findByUserId(userId);
		if(account==null) {
			throw new InternalExceptionHandler.ApiValidationException(ErrorCode.ER_1003,ErrorCode.ER_1003.getMessage());
		}  else if (account.getBalance()<money) {
			throw new InternalExceptionHandler.ApiValidationException(ErrorCode.ER_1004,ErrorCode.ER_1004.getMessage());
		}
		try {
			accountRepository.debitBalance(userId, money);
			return new StatusVO(true);
		} catch(Exception e) {
			throw new InternalExceptionHandler.ApiException(e,null);
		}
	}

	@Transactional
	public Account getBalance(Integer userId) {
		Account account=accountRepository.findByUserId(userId);
		return account;
	}
	
}
