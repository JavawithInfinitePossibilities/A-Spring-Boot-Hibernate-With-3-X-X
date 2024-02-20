/**
 * 
 */
package com.sid.tutorials.spring.boot3.hibernate.app.repositories;

import com.sid.tutorials.spring.boot3.hibernate.app.model.db.DoctorDetails;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Lenovo
 *
 */
public interface DoctorRepo extends JpaRepository<DoctorDetails, Integer> {

	public DoctorDetails getDoctorDetailsByFirstName(String firstName);

}
