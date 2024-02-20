/**
 * 
 */
package com.sid.tutorials.spring.boot3.hibernate.app.model.dto;

import jakarta.persistence.Embeddable;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Lenovo
 *
 */
@Data
@NoArgsConstructor
@Embeddable
public class Insurance {
	private String providerName;
	private double copay;

	/**
	 * @param providerName
	 * @param copay
	 */
	@Builder
	public Insurance(String providerName, double copay) {
		super();
		this.providerName = providerName;
		this.copay = copay;
	}
}
