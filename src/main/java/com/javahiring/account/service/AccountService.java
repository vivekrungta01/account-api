package com.javahiring.account.service;

import com.javahiring.account.common.Account;
import com.javahiring.account.common.StatusVO;

public interface AccountService {
	public Account createAccount(Account account);
	public StatusVO addMoneyToAccount(Integer userId,double money);
	public StatusVO deductMoneyFromAccount(Integer userId,double money);
	public Account getBalance(Integer userId);
}
