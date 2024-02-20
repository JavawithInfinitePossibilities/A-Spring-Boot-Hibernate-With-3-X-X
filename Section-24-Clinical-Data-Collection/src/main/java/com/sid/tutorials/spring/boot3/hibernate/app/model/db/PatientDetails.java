/**
 * 
 */
package com.sid.tutorials.spring.boot3.hibernate.app.model.db;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sid.tutorials.spring.boot3.hibernate.app.model.dto.Insurance;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

/**
 * @author Lenovo
 *
 */
@Data
@NoArgsConstructor
@Entity(name = "patients")
@JsonIgnoreProperties(value = { "doctorDetails", "appointments", "clinicalDatas" })
public class PatientDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String firstName;
	private String lastName;
	private String phone;
	@Embedded
	private Insurance insurance;
	private int age;

	@ManyToMany
	@JoinTable(name = "doctor_patient", joinColumns = @JoinColumn(name = "patientId", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "doctorId", referencedColumnName = "id"))
	private Set<DoctorDetails> doctorDetails;

	@OneToMany(mappedBy = "patientDetails", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Appointment> appointments;

	@OneToMany(mappedBy = "patientDetails", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ClinicalData> clinicalDatas;

	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param phone
	 * @param insurance
	 */
	@Builder
	public PatientDetails(String firstName, String lastName, String phone, Insurance insurance, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.insurance = insurance;
		this.age = age;
	}

}
