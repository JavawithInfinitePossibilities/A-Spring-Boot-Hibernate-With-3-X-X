/**
 * 
 */
package com.sid.tutorials.spring.boot3.hibernate.app.model.db;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Lenovo
 *
 */
@Data
@NoArgsConstructor
@Entity
public class ClinicalData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String component_name;
	private String component_value;
	@Temporal(TemporalType.DATE)
	private Date measuredDateTime;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "patientId", referencedColumnName = "id")
	private PatientDetails patientDetails;

	/**
	 * @param component_name
	 * @param component_value
	 * @param measuredDateTime
	 */
	@Builder
	public ClinicalData(String component_name, String component_value, Date measuredDateTime) {
		super();
		this.component_name = component_name;
		this.component_value = component_value;
		this.measuredDateTime = measuredDateTime;
	}

}
