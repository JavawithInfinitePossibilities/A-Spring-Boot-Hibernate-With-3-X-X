/**
 * 
 */
package com.sid.tutorials.spring.boot3.hibernate.app.services;

import com.sid.tutorials.spring.boot3.hibernate.app.model.db.PatientDetails;

import java.util.List;

/**
 * @author Lenovo
 *
 */
public interface IPatientService {

	public PatientDetails save(PatientDetails patientDetails);

	public PatientDetails get(int patientId);

	public PatientDetails getPatientByName(String firstName);

	public PatientDetails update(PatientDetails patientDetails);

	public List<PatientDetails> getAllPatient();
}
