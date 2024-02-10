/**
 * 
 */
package com.sid.tutorials.spring.boot3.hibernate.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Lenovo
 *
 */
@Data
@NoArgsConstructor
@Entity
public class BankAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountNo;

	private String name;
	private int balance;

	/**
	 * @param name
	 * @param balance
	 */
	@Builder
	public BankAccount(String name, int balance) {
		super();
		this.name = name;
		this.balance = balance;
	}
}
