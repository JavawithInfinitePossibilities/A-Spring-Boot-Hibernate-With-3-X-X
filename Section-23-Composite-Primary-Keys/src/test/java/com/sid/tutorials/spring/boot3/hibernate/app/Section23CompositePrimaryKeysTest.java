package com.sid.tutorials.spring.boot3.hibernate.app;

import com.sid.tutorials.spring.boot3.hibernate.app.bean.Car;
import com.sid.tutorials.spring.boot3.hibernate.app.bean.Person;
import com.sid.tutorials.spring.boot3.hibernate.app.mockdata.MockDataPrep;
import com.sid.tutorials.spring.boot3.hibernate.app.model.componentMapping.CustomerId;
import com.sid.tutorials.spring.boot3.hibernate.app.model.db.Customer;
import com.sid.tutorials.spring.boot3.hibernate.app.repositories.ICustomerRepo;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author kunmu On 14-02-2024
 */
@SpringBootTest(classes = Section23CompositePrimaryKeys.class)
class Section23CompositePrimaryKeysTest {


    @Autowired
    private ICustomerRepo iCustomerRepo;

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

    @Test
    public void testSaveCustomer() {
        CustomerId id = CustomerId.builder().id(1).email("abc@gmail.com").build();
        Customer customer = Customer.builder().customerId(id).name("ZYX").build();
        Customer saveCustomer = iCustomerRepo.save(customer);
    }
}