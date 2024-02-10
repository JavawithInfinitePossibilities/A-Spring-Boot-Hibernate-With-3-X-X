package com.sid.tutorials.spring.boot3.hibernate.app;

import com.sid.tutorials.spring.boot3.hibernate.app.bean.Car;
import com.sid.tutorials.spring.boot3.hibernate.app.bean.Person;
import com.sid.tutorials.spring.boot3.hibernate.app.entity.Client;
import com.sid.tutorials.spring.boot3.hibernate.app.entity.PhoneNumber;
import com.sid.tutorials.spring.boot3.hibernate.app.mockdata.MockDataPrep;
import com.sid.tutorials.spring.boot3.hibernate.app.repository.IClientRepo;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author kunmu On 10-02-2024
 */
@SpringBootTest(classes = Section14RelationshipsinHibernate.class)
class Section14RelationshipsinHibernateTest {
    @Autowired
    @Qualifier("mockDataPrep")
    private MockDataPrep mockDataPrep;


    @Autowired
    private IClientRepo iClientRepo;

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

    /*@Disabled*/
    @Test
    public void testCreateClientPhone() {
        PhoneNumber phoneNumber = PhoneNumber.builder().number("1234567890").type("Vodaphone").build();
        PhoneNumber phoneNumber2 = PhoneNumber.builder().number("0987654321").type("Vodaphone").build();
        PhoneNumber phoneNumber3 = PhoneNumber.builder().number("0369852147").type("Vodaphone").build();
        Set<PhoneNumber> phoneNumbers = Set.of(phoneNumber, phoneNumber2, phoneNumber3);
        Client entity = Client.builder().name("siddhant").phoneNumber(phoneNumbers).build();
        phoneNumber.setClient(entity);
        phoneNumber2.setClient(entity);
        phoneNumber3.setClient(entity);
        Client saveClient = iClientRepo.save(entity);
        assertEquals(entity, saveClient);
    }

    @Disabled
    @Test
    public void testCreateClientPhoneNumber() {
        PhoneNumber phoneNumber = PhoneNumber.builder().number("1234567890").type("Airtel").build();
        PhoneNumber phoneNumber2 = PhoneNumber.builder().number("0987654321").type("Airtel").build();
        PhoneNumber phoneNumber3 = PhoneNumber.builder().number("0369852147").type("Airtel").build();
        Client entity = Client.builder().name("siddhant").build();
        entity.addPhoneNumber(phoneNumber);
        entity.addPhoneNumber(phoneNumber2);
        entity.addPhoneNumber(phoneNumber3);
        Client saveClient = iClientRepo.save(entity);
        assertEquals(entity, saveClient);
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void testSelectClientPhoneNumber() throws InterruptedException {
        Client client = iClientRepo.findById(2).get();
        System.out.println(client);
        Thread.sleep(5000);
        client.setName("kunmun");
        Set<PhoneNumber> phoneNumbers = client.getPhoneNumbers();
        phoneNumbers.stream().forEach(phno -> {
            if (phno.getType() != null) {
                phno.setType("Air-tel");
            }
        });
        Client saveClient = iClientRepo.save(client);
        assertEquals(client, saveClient);
    }
}