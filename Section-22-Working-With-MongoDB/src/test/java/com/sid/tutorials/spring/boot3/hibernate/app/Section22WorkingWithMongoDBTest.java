package com.sid.tutorials.spring.boot3.hibernate.app;

import com.sid.tutorials.spring.boot3.hibernate.app.bean.Car;
import com.sid.tutorials.spring.boot3.hibernate.app.bean.Person;
import com.sid.tutorials.spring.boot3.hibernate.app.entity.Product;
import com.sid.tutorials.spring.boot3.hibernate.app.mockdata.MockDataPrep;
import com.sid.tutorials.spring.boot3.hibernate.app.repositories.IProductMogRepo;
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
@SpringBootTest(classes = Section22WorkingWithMongoDB.class)
class Section22WorkingWithMongoDBTest {

    @Autowired
    private IProductMogRepo iProductMogRepo;

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
    void testProductLoads() {
        Product product = new Product();
        product.setName("orange");
        product.setPrice(1000d);

        Product saveProduct = iProductMogRepo.save(product);
        System.out.println("Save product: " + saveProduct.getId());
    }

    @Disabled
    @Test
    public void testFindAll() {
        List<Product> findAll = iProductMogRepo.findAll();
        findAll.stream().forEach(p -> {
            System.out.println(p.getName());
        });
    }

    @Disabled
    @Test
    public void testDeleteAll() {
        iProductMogRepo.deleteById("5f774d2acc50c570a29cc8e9");
    }
}