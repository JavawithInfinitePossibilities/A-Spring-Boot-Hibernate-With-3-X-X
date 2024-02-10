package com.sid.tutorials.spring.boot3.hibernate.app;

import com.sid.tutorials.spring.boot3.hibernate.app.bean.Car;
import com.sid.tutorials.spring.boot3.hibernate.app.bean.Person;
import com.sid.tutorials.spring.boot3.hibernate.app.entity.Programmer;
import com.sid.tutorials.spring.boot3.hibernate.app.entity.Project;
import com.sid.tutorials.spring.boot3.hibernate.app.mockdata.MockDataPrep;
import com.sid.tutorials.spring.boot3.hibernate.app.repository.IProgrammerRepo;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author kunmu On 10-02-2024
 */
@SpringBootTest(classes = Section15ManytoManyAssociation.class)
class Section15ManytoManyAssociationTest {
    @Autowired
    @Qualifier("mockDataPrep")
    private MockDataPrep mockDataPrep;

    @Autowired
    private IProgrammerRepo iProgrammer;

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
    public void testMtoMProgrammerProjectNumber() {
        Programmer programmer = Programmer.builder().name("sid sahu").salary(1000).build();
        Project project = Project.builder().name("IMOS-1").build();
        Project project2 = Project.builder().name("ETD-1").build();
        programmer.addProject(project);
        programmer.addProject(project2);
        iProgrammer.save(programmer);
    }

    @Disabled
    @Test
    @Transactional
    public void testMtoMSelectProgrammerProjectNumber() {
        Programmer programmerSelect = iProgrammer.findById(3).get();
        assertEquals(programmerSelect.getName(), "sid sahu");
        System.out.println(programmerSelect);
    }
}