/**
 * 
 */
package com.sid.tutorials.spring.boot3.hibernate.app.model.db;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author kunmu
 *
 */
@Data
@ToString
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "pmode", discriminatorType = DiscriminatorType.STRING)
public abstract class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double amount;

	/**
	 * @param id
	 * @param amount
	 */
	protected Payment(double amount) {
		super();
		this.amount = amount;
	}

}
