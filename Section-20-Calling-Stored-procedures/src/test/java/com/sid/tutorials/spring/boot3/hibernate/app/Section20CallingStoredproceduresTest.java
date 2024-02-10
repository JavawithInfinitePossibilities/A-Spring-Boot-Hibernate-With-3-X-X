package com.sid.tutorials.spring.boot3.hibernate.app;

import com.sid.tutorials.spring.boot3.hibernate.app.bean.Car;
import com.sid.tutorials.spring.boot3.hibernate.app.bean.Person;
import com.sid.tutorials.spring.boot3.hibernate.app.entity.Product;
import com.sid.tutorials.spring.boot3.hibernate.app.mockdata.MockDataPrep;
import com.sid.tutorials.spring.boot3.hibernate.app.repositories.IProductRepo;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author kunmu On 11-02-2024
 */
@SpringBootTest(classes = Section20CallingStoredprocedures.class)
class Section20CallingStoredproceduresTest {
    @Autowired
    private IProductRepo iProductRepo;

    @Autowired
    @Qualifier("mockDataPrep")
    private MockDataPrep mockDataPrep;

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
    public void testGetAllProduct() {
        List<Product> saveProduct = iProductRepo.getAllProduct();
        System.out.println(saveProduct);
    }

    @Disabled
    @Test
    public void testReadProduct() {
        List<Product> product = iProductRepo.getAllProductsByPrice(1000);
        System.out.println(product);
    }


    @Test
    public void testUpdateProduct() {
        System.out.println(iProductRepo.getAllProductCountByPrice(4000));
    }
}