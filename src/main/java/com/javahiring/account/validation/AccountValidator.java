package com.javahiring.account.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.javahiring.account.common.Account;
import com.javahiring.account.common.AccountCreditDebitRequest;
import com.javahiring.account.common.ErrorCode;
import com.javahiring.account.controller.InternalExceptionHandler.ApiValidationException;

@Component
public class AccountValidator {
	private static final Logger logger = LoggerFactory.getLogger(AccountValidator.class);
	

	public void validateCreateAccountRequest(Account account) {
		logger.info("Validation for CreateAccountRequest"+account);
		if(account==null || account.getUserId()==null) {
			throw new ApiValidationException(ErrorCode.ER_1001,ErrorCode.ER_1001.getMessage());
		}
	}
	
	public void validateAccountDebitCredit(AccountCreditDebitRequest account) {
		logger.info("Validation for AccountDebitCredit"+account);
		if(account==null || account.getUserId()==null) {
			throw new ApiValidationException(ErrorCode.ER_1001,ErrorCode.ER_1001.getMessage());
		} else if (account.getAmount()==null) {
			throw new ApiValidationException(ErrorCode.ER_1001,ErrorCode.ER_1001.getMessage());
		}
	}
	
	public void validateGetAccount(Integer userId) {
		logger.info("Validation for Get Account for userId "+userId);
		if(userId==null) {
			throw new ApiValidationException(ErrorCode.ER_1001,ErrorCode.ER_1001.getMessage());
		}
	}
}
