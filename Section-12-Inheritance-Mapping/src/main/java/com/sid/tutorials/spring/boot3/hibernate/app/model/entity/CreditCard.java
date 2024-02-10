/**
 * 
 */
package com.sid.tutorials.spring.boot3.hibernate.app.model.entity;

import com.sid.tutorials.spring.boot3.hibernate.app.model.db.Payment;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author kunmu
 *
 */
@Data
@NoArgsConstructor
@Entity
@DiscriminatorValue(value = "CC")
public class CreditCard extends Payment {

	private String creditCardNumber;

	/**
	 * @param id
	 * @param amount
	 * @param creditCardNumber
	 */
	@Builder
	public CreditCard(double amount, String creditCardNumber) {
		super(amount);
		this.creditCardNumber = creditCardNumber;
	}

}
