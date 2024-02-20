/**
 * 
 */
package com.sid.tutorials.spring.boot3.hibernate.app.repositories;

import com.sid.tutorials.spring.boot3.hibernate.app.model.db.PatientDetails;
import com.sid.tutorials.spring.boot3.hibernate.app.model.dto.PatientDetailsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Lenovo
 *
 */
public interface PatientRepo extends JpaRepository<PatientDetails, Integer> {

	public PatientDetails getPatientDetailsByFirstName(String firstName);

	@Query(value = "Select id as id,first_name as firstName,last_name as lastName,phone as phone,age as age "
			+ "from patients where last_name=:lastName", nativeQuery = true)
	public List<PatientDetailsDTO> getPatientDetailsByLastName(@Param("lastName") String lastName);

}
