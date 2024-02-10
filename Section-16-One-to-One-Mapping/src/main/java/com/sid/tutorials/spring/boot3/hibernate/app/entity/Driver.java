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
@Entity
public class Driver implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int driverId;
	private String firstName;
	private String lastName;
	private int age;

	@OneToOne(mappedBy = "driver")
	private License license;

	/**
	 * @param firstName
	 * @param lastName
	 * @param age
	 * @param license
	 */
	@Builder
	public Driver(String firstName, String lastName, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
}
