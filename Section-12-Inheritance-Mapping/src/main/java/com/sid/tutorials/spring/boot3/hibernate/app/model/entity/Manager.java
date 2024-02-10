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
public class Manager extends Person {

	private String employeeNumber;

	/**
	 * @param firstName
	 * @param lastName
	 * @param employeeNumber
	 */
	@Builder
	public Manager(String firstName, String lastName, String employeeNumber) {
		super(firstName, lastName);
		this.employeeNumber = employeeNumber;
	}

}
