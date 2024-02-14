/**
 * 
 */
package com.sid.tutorials.spring.boot3.hibernate.app.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author kunmu
 *
 */
@Setter
@Getter
@NoArgsConstructor
@Document
public class Product {

	@Id
	private String id;
	private String name;
	private double price;

}
