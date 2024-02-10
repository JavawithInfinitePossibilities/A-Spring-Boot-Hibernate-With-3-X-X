/**
 * 
 */
package com.sid.tutorials.spring.boot3.hibernate.app.services;

import com.sid.tutorials.spring.boot3.hibernate.app.entity.BankAccount;
import com.sid.tutorials.spring.boot3.hibernate.app.repositories.IBankAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Lenovo
 *
 */
@Service
public class BankAccountServicesImpl implements IBankAccountService {

	@Autowired
	private IBankAccountRepo iBankAccountRepo;

	@Override
	public BankAccount save(BankAccount account) {
		return iBankAccountRepo.save(account);
	}

	/**
	 * A Transaction is a do all or nothing will happen. <br/> 
	 * All the communication to database in one transaction is treated as one transaction.
	 */
	@Override
	@Transactional
	public void transactionAccount(BankAccount from, BankAccount to, int substract) {
		from.setBalance(from.getBalance() - substract);
		iBankAccountRepo.save(from);
		/*if (true) {
			throw new RuntimeException("This is a custom exception");
		}*/
		to.setBalance(to.getBalance() + substract);
		iBankAccountRepo.save(to);
	}
}
