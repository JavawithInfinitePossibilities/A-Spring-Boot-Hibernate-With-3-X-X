/**
 * 
 */
package com.sid.tutorials.spring.boot3.hibernate.app.repositories;

import com.sid.tutorials.spring.boot3.hibernate.app.model.db.PatientDetails;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Lenovo
 *
 */
public interface PatientRepo extends JpaRepository<PatientDetails, Integer> {

	public PatientDetails getPatientDetailsByFirstName(String firstName);

}
