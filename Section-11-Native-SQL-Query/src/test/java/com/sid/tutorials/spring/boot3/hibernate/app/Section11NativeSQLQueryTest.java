package com.sid.tutorials.spring.boot3.hibernate.app;

import com.sid.tutorials.spring.boot3.hibernate.app.bean.Car;
import com.sid.tutorials.spring.boot3.hibernate.app.bean.Person;
import com.sid.tutorials.spring.boot3.hibernate.app.entity.CarEntity;
import com.sid.tutorials.spring.boot3.hibernate.app.entity.PersonEntity;
import com.sid.tutorials.spring.boot3.hibernate.app.mockdata.MockDataPrep;
import com.sid.tutorials.spring.boot3.hibernate.app.services.CarServices;
import com.sid.tutorials.spring.boot3.hibernate.app.services.PersonServices;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author kunmu On 31-12-2023
 */
@SpringBootTest(classes = Section11NativeSQLQuery.class)
class Section11NativeSQLQueryTest {
    @Autowired
    @Qualifier("mockDataPrep")
    private MockDataPrep mockDataPrep;

    @Autowired
    private CarServices carServices;

    @Autowired
    private PersonServices personServices;

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
    void saveCarsDetails() {
        try {
            List<Car> cars = mockDataPrep.getCars();
            cars.stream().map(carBean -> {
                return CarEntity.builder()
                        .id(carBean.getId())
                        .price(carBean.getPrice())
                        .year(carBean.getYear())
                        .make(carBean.getMake())
                        .model(carBean.getModel())
                        .color(carBean.getColor())
                        .build();
            }).forEach(car -> {
                CarEntity carDetails = carServices.createCarDetails(car);
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Disabled
    @Test
    void savePersonsDetails() {
        try {
            List<Person> personList = mockDataPrep.getPeople();
            personList.stream().map(personBean -> {
                return PersonEntity.builder()
                        .id(personBean.getId())
                        .firstName(personBean.getFirstName())
                        .lastName(personBean.getLastName())
                        .age(personBean.getAge())
                        .email(personBean.getEmail())
                        .gender(personBean.getGender())
                        .build();
            }).forEach(person -> {
                PersonEntity personDetails = personServices.createPersonDetails(person);
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Disabled
    @Test
    void savePersonsDetailsList() {
        try {
            List<Person> personList = mockDataPrep.getPeople();
            List<PersonEntity> personEntityList = personList.stream().map(personBean -> {
                return PersonEntity.builder()
                        .id(personBean.getId())
                        .firstName(personBean.getFirstName())
                        .lastName(personBean.getLastName())
                        .age(personBean.getAge())
                        .email(personBean.getEmail())
                        .gender(personBean.getGender())
                        .build();
            }).collect(Collectors.toList());
            List<PersonEntity> personDetailsList = personServices.createPersonDetailsList(personEntityList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Disabled
    @Test
    void getPersonDetails() {
        List<PersonEntity> allPersonDetails = personServices.getAllPersonDetails();
        allPersonDetails.stream().forEach(person -> {
            System.out.println(person);
        });
    }

    @Disabled
    @Test
    void updateCarDetails() {
        CarEntity carEntity = carServices.getCarDetailsById(156);
        carEntity.setColor("Green");
        carServices.createCarDetails(carEntity);
    }

    @Disabled
    @Test
    void getCarDetails() {
        List<CarEntity> allCarDetails = carServices.getCarDetailsByMakeName("Ford");
        allCarDetails.stream().forEach(person -> {
            System.out.println(person);
        });
        System.out.println("Number of record returned : " + allCarDetails.size());
    }
}