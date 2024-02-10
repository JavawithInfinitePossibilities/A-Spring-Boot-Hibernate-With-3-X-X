/**
 * 
 */
package com.sid.tutorials.spring.boot3.hibernate.app.services;

import com.sid.tutorials.spring.boot3.hibernate.app.entity.BankAccount;

/**
 * @author Lenovo
 *
 */
public interface IBankAccountService {
	public BankAccount save(BankAccount account);

	public void transactionAccount(BankAccount from, BankAccount to, int substract);
}
