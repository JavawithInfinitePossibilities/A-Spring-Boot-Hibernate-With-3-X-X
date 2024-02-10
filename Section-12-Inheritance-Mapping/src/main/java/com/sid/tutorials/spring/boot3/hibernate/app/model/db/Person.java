/**
 * 
 */
package com.sid.tutorials.spring.boot3.hibernate.app.model.db;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author kunmu
 *
 */
@Data
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	private String firstName;
	private String lastName;

	/**
	 * @param firstName
	 * @param lastName
	 */
	protected Person(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
