/**
 * 
 */
package com.sid.tutorials.spring.boot3.hibernate.app.services;

import com.sid.tutorials.spring.boot3.hibernate.app.model.db.DoctorDetails;

/**
 * @author Lenovo
 *
 */
public interface IDoctorServices {

	public DoctorDetails save(DoctorDetails doctorDetails);

	public DoctorDetails get(int doctorId);

	public DoctorDetails getDoctorByName(String firstName);

	public DoctorDetails update(DoctorDetails doctorDetails);
}
