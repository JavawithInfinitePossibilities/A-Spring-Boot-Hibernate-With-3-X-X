package com.sid.tutorials.spring.boot3.hibernate.app;

import com.sid.tutorials.spring.boot3.hibernate.app.bean.Car;
import com.sid.tutorials.spring.boot3.hibernate.app.bean.Person;
import com.sid.tutorials.spring.boot3.hibernate.app.entity.Driver;
import com.sid.tutorials.spring.boot3.hibernate.app.entity.License;
import com.sid.tutorials.spring.boot3.hibernate.app.mockdata.MockDataPrep;
import com.sid.tutorials.spring.boot3.hibernate.app.repository.ILicenseRepo;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author kunmu On 10-02-2024
 */
@SpringBootTest(classes = Section17HibernateCachingMechanism.class)
class Section17HibernateCachingMechanismTest {
    @Autowired
    @Qualifier("mockDataPrep")
    private MockDataPrep mockDataPrep;

    @Autowired
    private ILicenseRepo iLicenseRepo;

    @Autowired
    private EntityManager entityManager;
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
    public void testOneToOneDriverlicense() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        License license = License.builder().type("Bike").validFrom(format.parse(LocalDate.of(2010, 01, 01).toString()))
                .validTo(format.parse(LocalDate.now().toString())).build();
        Driver driver = Driver.builder().firstName("Sid").lastName("Sahu").age(33).build();
        license.setDriver(driver);
        driver.setLicense(license);
        License LicenseSave = iLicenseRepo.save(license);
        assertEquals(license, LicenseSave);
    }

    @Test
    @Transactional
    public void testSelectOneToOneDriverlicense() {
        Session session = entityManager.unwrap(Session.class);
        License license = iLicenseRepo.findById(1).get();

        iLicenseRepo.findById(1);
        iLicenseRepo.findById(1);
        session.evict(license);
        iLicenseRepo.findById(1);
    }
}