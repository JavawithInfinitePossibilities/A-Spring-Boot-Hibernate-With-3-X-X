package com.sid.tutorials.spring.boot3.hibernate.app;

import com.sid.tutorials.spring.boot3.hibernate.app.bean.Car;
import com.sid.tutorials.spring.boot3.hibernate.app.bean.Person;
import com.sid.tutorials.spring.boot3.hibernate.app.entity.Address;
import com.sid.tutorials.spring.boot3.hibernate.app.entity.Employee;
import com.sid.tutorials.spring.boot3.hibernate.app.mockdata.MockDataPrep;
import com.sid.tutorials.spring.boot3.hibernate.app.repositories.IEmployeeRepo;
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
@SpringBootTest(classes = Section13ComponrntMapping.class)
class Section13ComponrntMappingTest {
    @Autowired
    @Qualifier("mockDataPrep")
    private MockDataPrep mockDataPrep;

    @Autowired
    private IEmployeeRepo iEmployeeRepo;

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

    @Test
    public void testCreateemployee() {
        Address address = Address.builder().streetaddress("101").city("Bangalore").state("Karnatak").zipcode("560037")
                .country("India").build();
        Employee employee = Employee.builder().firstName("Sid").lastName("Sahu").address(address).build();
        Employee saveEmployee = iEmployeeRepo.save(employee);
        System.out.println(saveEmployee);
    }
}