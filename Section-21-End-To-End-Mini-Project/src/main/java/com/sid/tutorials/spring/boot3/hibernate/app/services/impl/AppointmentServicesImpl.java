/**
 * 
 */
package com.sid.tutorials.spring.boot3.hibernate.app.services.impl;

import com.sid.tutorials.spring.boot3.hibernate.app.model.db.Appointment;
import com.sid.tutorials.spring.boot3.hibernate.app.repositories.AppointmentRepo;
import com.sid.tutorials.spring.boot3.hibernate.app.services.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Lenovo
 *
 */
@Service
@Transactional
public class AppointmentServicesImpl implements IAppointmentService {

	@Autowired
	private AppointmentRepo appointmentRepo;

	@Override
	public Appointment save(Appointment doctorDetails) {
		return appointmentRepo.save(doctorDetails);
	}

	@Override
	public Appointment get(int appointmentId) {
		return appointmentRepo.findById(appointmentId).get();
	}

	@Override
	public Appointment update(Appointment doctorDetails) {
		return appointmentRepo.save(doctorDetails);
	}

}
