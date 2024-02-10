/**
 * 
 */
package com.sid.tutorials.spring.boot3.hibernate.app.entity;

import jakarta.persistence.*;
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
public class Image {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@Lob
	@Column(name = "data", length = 1000)
	private byte[] data;

	/**
	 * @param name
	 * @param data
	 */
	@Builder
	public Image(String name, byte[] data) {
		super();
		this.name = name;
		this.data = data;
	}
}
