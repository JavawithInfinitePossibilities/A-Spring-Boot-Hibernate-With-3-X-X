package com.sid.tutorials.spring.boot3.hibernate.app;

import com.sid.tutorials.spring.boot3.hibernate.app.bean.Car;
import com.sid.tutorials.spring.boot3.hibernate.app.bean.Person;
import com.sid.tutorials.spring.boot3.hibernate.app.mockdata.MockDataPrep;
import com.sid.tutorials.spring.boot3.hibernate.app.model.db.Appointment;
import com.sid.tutorials.spring.boot3.hibernate.app.model.db.DoctorDetails;
import com.sid.tutorials.spring.boot3.hibernate.app.model.db.PatientDetails;
import com.sid.tutorials.spring.boot3.hibernate.app.model.dto.Insurance;
import com.sid.tutorials.spring.boot3.hibernate.app.services.IAppointmentService;
import com.sid.tutorials.spring.boot3.hibernate.app.services.IDoctorServices;
import com.sid.tutorials.spring.boot3.hibernate.app.services.IPatientService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author kunmu On 13-02-2024
 */
@SpringBootTest(classes = Section21EndToEndMiniProject.class)
class Section21EndToEndMiniProjectTest {

    Random random = new Random();

    @Autowired
    private IDoctorServices iDoctorServices;

    @Autowired
    private IPatientService iPatientService;

    @Autowired
    private IAppointmentService iAppointmentService;

    @Autowired
    @Qualifier("mockDataPrep")
    private MockDataPrep mockDataPrep;

    @Disabled
    @Test
    void getPeople() {
        try {
            List<Person> people = mockDataPrep.getPeople();
            people.stream().forEach(p -> System.out.println(p.toString()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Disabled
    @Test
    void getCars() {
        try {
            List<Car> cars = mockDataPrep.getCars();
            cars.stream().forEach(car -> System.out.println(car.toString()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Disabled
    @Test
    void testLoadDoctor() {
        int count = 2;
        while (count < 6) {
            count++;
            DoctorDetails doctorDetails = DoctorDetails.builder().firstName("Doctor-First-" + random.nextInt(10))
                    .lastName("Doctor-last-" + random.nextInt(10)).specility("Doctor-Specility-" + random.nextInt(10))
                    .build();
            iDoctorServices.save(doctorDetails);
        }
    }

    @Disabled
    @Test
    public void testLoadPatient() {
        int count = 2;
        while (count < 11) {
            count++;
            Insurance insurance = Insurance.builder().providerName("Insurance-" + random.nextInt(10)).copay(10d)
                    .build();
            PatientDetails patientDetails = PatientDetails.builder().firstName("Patient-First-" + random.nextInt(10))
                    .lastName("Patient-Last-" + random.nextInt(10)).phone("1230645789").insurance(insurance)
                    .age(random.nextInt(50)).build();
            int doctorNumber = random.nextInt(4);
            System.out.println("Doctor number : " + doctorNumber);
            DoctorDetails doctorDetail;
            if (doctorNumber > 0) {
                doctorDetail = iDoctorServices.get(doctorNumber);
            } else {
                doctorNumber = 2;
                doctorDetail = iDoctorServices.get(doctorNumber);
            }
            Set<DoctorDetails> doctorDetails = new HashSet<DoctorDetails>();
            doctorDetails.add(doctorDetail);
            patientDetails.setDoctorDetails(doctorDetails);
            iPatientService.save(patientDetails);
        }
    }

    @Test
    public void testLoadAppointment() throws ParseException {
        Timestamp date = Timestamp.valueOf(LocalDateTime.now());
        Appointment appointment = Appointment.builder().appointmentTime(date).strat(true).end(true)
                .reason("cardiac arrest").build();
        DoctorDetails doctorDetail = iDoctorServices.get(3);
        PatientDetails patientDetails = iPatientService.get(57);

        appointment.setDoctorDetails(doctorDetail);
        appointment.setPatientDetails(patientDetails);
        iAppointmentService.save(appointment);
    }
}