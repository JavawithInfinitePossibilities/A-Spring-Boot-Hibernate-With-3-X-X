package com.sid.tutorials.spring.boot3.hibernate.app;

import com.sid.tutorials.spring.boot3.hibernate.app.bean.Car;
import com.sid.tutorials.spring.boot3.hibernate.app.bean.Person;
import com.sid.tutorials.spring.boot3.hibernate.app.mockdata.MockDataPrep;
import com.sid.tutorials.spring.boot3.hibernate.app.model.entity.*;
import com.sid.tutorials.spring.boot3.hibernate.app.repositories.IPaymentRepo;
import com.sid.tutorials.spring.boot3.hibernate.app.repositories.IPersonRepo;
import com.sid.tutorials.spring.boot3.hibernate.app.repositories.IVehicleRepo;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author kunmu On 10-02-2024
 */
@SpringBootTest(classes = Section12InheritanceMapping.class)
class Section12InheritanceMappingTest {
    @Autowired
    @Qualifier("mockDataPrep")
    private MockDataPrep mockDataPrep;


    @Autowired
    private IPaymentRepo iPaymentRepo;

    @Autowired
    private IPersonRepo iPersonRepo;

    @Autowired
    private IVehicleRepo iVehicleRepo;

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
    public void testCreatePayment() {
        CreditCard creditCard = iPaymentRepo.save(CreditCard.builder().amount(1500)
                .creditCardNumber("123567890123").build());
        Check check = iPaymentRepo.save(Check.builder().amount(2000).checkNumber("12345690321").build());
        System.out.println(creditCard);
        System.out.println(check);
    }

    @Disabled
    @Test
    public void testCreatePerson() {
        Contractor contractor = iPersonRepo.save(Contractor.builder().firstName("sidhant").lastName("sahu")
                .employeeNumber("123567890").managerNumber("098745631").build());
        Manager manager = iPersonRepo
                .save(Manager.builder().firstName("Sarang").lastName("Joshi").employeeNumber("098745631").build());
        System.out.println(contractor);
        System.out.println(manager);
    }

    @Test
    public void testCreateVehicle() {
        Vehicle4Wheeler vehicle4Wheeler = iVehicleRepo.save(Vehicle4Wheeler.builder().vahicleNumber("KA-53 2422")
                .vahicleCategory("Car").vehicleType("SUV").vehileBrand("AUDI").build());
        Vehicle2Wheeler vehicle2Wheeler = iVehicleRepo.save(Vehicle2Wheeler.builder().vahicleNumber("KA-53 2224")
                .vehicleType("Byke").vahicleCategory("Racing").vehileBrand("Bajaj").build());
        System.out.println(vehicle4Wheeler);
        System.out.println(vehicle2Wheeler);
    }
}