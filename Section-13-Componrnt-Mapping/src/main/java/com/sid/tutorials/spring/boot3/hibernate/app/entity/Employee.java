/**
 * 
 */
package com.sid.tutorials.spring.boot3.hibernate.app.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Lenovo
 *
 */
@Data
@NoArgsConstructor
@Entity(name = "employee")
@Table
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long id;

	private String firstName;
	private String lastName;

	@Embedded
	private Address address;

	/**
	 * @param firstName
	 * @param lastName
	 * @param address
	 */
	@Builder
	public Employee(String firstName, String lastName, Address address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}

}
