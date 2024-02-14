/**
 * 
 */
package com.sid.tutorials.spring.boot3.hibernate.app.model.db;

import com.sid.tutorials.spring.boot3.hibernate.app.model.componentMapping.CustomerId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
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
public class Customer {

	@EmbeddedId
	private CustomerId customerId;
	private String name;

	/**
	 * @param customerId
	 * @param name
	 */
	@Builder
	public Customer(CustomerId customerId, String name) {
		super();
		this.customerId = customerId;
		this.name = name;
	}

}
