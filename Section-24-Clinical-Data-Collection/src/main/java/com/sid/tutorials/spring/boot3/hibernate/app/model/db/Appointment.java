/**
 * 
 */
package com.sid.tutorials.spring.boot3.hibernate.app.model.db;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;

/**
 * @author Lenovo
 *
 */
@Setter
@Getter
@NoArgsConstructor
@Entity
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Timestamp appointmentTime;
	private boolean strat;
	private boolean end;
	private String reason;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "patientId", referencedColumnName = "id")
	private PatientDetails patientDetails;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctorId", referencedColumnName = "id")
	private DoctorDetails doctorDetails;

	/**
	 * @param appointmentTime
	 * @param strat
	 * @param end
	 * @param reason
	 */
	@Builder
	public Appointment(Timestamp appointmentTime, boolean strat, boolean end, String reason) {
		super();
		this.appointmentTime = appointmentTime;
		this.strat = strat;
		this.end = end;
		this.reason = reason;
	}
}
