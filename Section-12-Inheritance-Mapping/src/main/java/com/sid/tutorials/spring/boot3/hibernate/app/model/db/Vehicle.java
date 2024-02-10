/**
 * 
 */
package com.sid.tutorials.spring.boot3.hibernate.app.model.db;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Lenovo
 *
 */
@Data
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	private String vahicleNumber;
	private String vahicleCategory;

	/**
	 * @param vahicleNumber
	 * @param vahicleCategory
	 */
	public Vehicle(String vahicleNumber, String vahicleCategory) {
		this.vahicleNumber = vahicleNumber;
		this.vahicleCategory = vahicleCategory;
	}

}
