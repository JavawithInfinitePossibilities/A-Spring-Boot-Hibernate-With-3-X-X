/**
 * 
 */
package com.sid.tutorials.spring.boot3.hibernate.app.controllers;

import com.sid.tutorials.spring.boot3.hibernate.app.model.db.PatientDetails;
import com.sid.tutorials.spring.boot3.hibernate.app.model.dto.PatientDetailsDTO;
import com.sid.tutorials.spring.boot3.hibernate.app.services.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Lenovo
 *
 */
@RestController
@RequestMapping("/api")
public class PatientController {

	@Autowired
	private IPatientService iPatientService;

	@RequestMapping(value = "/getAllPatient", method = RequestMethod.GET)
	private List<PatientDetails> getAllPatient() {
		return iPatientService.getAllPatient();
	}

	@RequestMapping(value = "/getPatientById/{patientId}", method = RequestMethod.GET)
	public PatientDetails getPatient(@PathVariable("patientId") int patientId) {
		return iPatientService.get(patientId);
	}

	@RequestMapping(value = "/getPatientByLastName/{patientLastName}", method = RequestMethod.GET)
	public PatientDetailsDTO getPatientByLastName(@PathVariable("patientLastName") String patientLastName) {
		return iPatientService.getPatientByLast(patientLastName);
	}

	@RequestMapping(value = "/savePatient", method = RequestMethod.POST)
	public PatientDetails savePatient(@RequestBody PatientDetails patientDetails) {
		return iPatientService.save(patientDetails);
	}
}
