/**
 * 
 */
package com.sid.tutorials.spring.boot3.hibernate.app.model.entity;

import com.sid.tutorials.spring.boot3.hibernate.app.model.db.Person;
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
public class Contractor extends Person {

	private String employeeNumber;
	private String managerNumber;

	/**
	 * @param firstName
	 * @param lastName
	 * @param employeeNumber
	 * @param managerNumber
	 */
	@Builder
	public Contractor(String firstName, String lastName, String employeeNumber, String managerNumber) {
		super(firstName, lastName);
		this.employeeNumber = employeeNumber;
		this.managerNumber = managerNumber;
	}
}
