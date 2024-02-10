/**
 * 
 */
package com.sid.tutorials.spring.boot3.hibernate.app.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Lenovo
 *
 */
@Data
@NoArgsConstructor
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class License implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String type;
	@Temporal(TemporalType.DATE)
	private Date validFrom;
	@Temporal(TemporalType.DATE)
	private Date validTo;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "driverId")
	private Driver driver;

	/**
	 * @param type
	 * @param validFrom
	 * @param validTo
	 * @param driver
	 */
	@Builder
	public License(String type, Date validFrom, Date validTo) {
		super();
		this.type = type;
		this.validFrom = validFrom;
		this.validTo = validTo;
	}

}
