/**
 * 
 */
package com.sid.tutorials.spring.boot3.hibernate.app.services;

import com.sid.tutorials.spring.boot3.hibernate.app.model.db.Appointment;

/**
 * @author Lenovo
 *
 */
public interface IAppointmentService {

	public Appointment save(Appointment doctorDetails);

	public Appointment get(int appointmentId);

	public Appointment update(Appointment doctorDetails);
}
