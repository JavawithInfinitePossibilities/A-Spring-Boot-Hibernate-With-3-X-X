/**
 * 
 */
package com.sid.tutorials.spring.boot3.hibernate.app.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Lenovo
 *
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
public class PhoneNumber {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String number;
	private String type;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clientId")
	private Client client;

	/**
	 * @param number
	 * @param type
	 * @param client
	 */
	@Builder
	public PhoneNumber(String number, String type) {
		super();
		this.number = number;
		this.type = type;
	}
}
