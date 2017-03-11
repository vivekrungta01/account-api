package com.javahiring.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.javahiring.account.common.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{
	
	@Modifying
	@Query("Update Account a SET a.balance=a.balance+:amount where a.userId=:userId")
	public void creditBalance(@Param("userId") Integer userId,@Param("amount") double amount);

	@Modifying
	@Query("Update Account a SET a.balance=a.balance-:amount where a.userId=:userId")
	public void debitBalance(@Param("userId") Integer userId,@Param("amount") double amount);

	public Account findByUserId(Integer userId);
}
