package com.sid.tutorials.spring.boot3.hibernate.app;

import com.sid.tutorials.spring.boot3.hibernate.app.bean.Car;
import com.sid.tutorials.spring.boot3.hibernate.app.bean.Person;
import com.sid.tutorials.spring.boot3.hibernate.app.entity.Image;
import com.sid.tutorials.spring.boot3.hibernate.app.mockdata.MockDataPrep;
import com.sid.tutorials.spring.boot3.hibernate.app.repositories.IMageDBRepo;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author kunmu On 11-02-2024
 */
@SpringBootTest(classes = Section19SaveandRetrieveFile.class)
class Section19SaveandRetrieveFileTest {
    @Autowired
    @Qualifier("mockDataPrep")
    private MockDataPrep mockDataPrep;

    @Autowired
    private IMageDBRepo iMageDBRepo;

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
    public void testImageBLOB() throws IOException {
        File file = new File("E:\\Test-Image\\IMG_1338~photo.jpg");
        byte[] fileByte = new byte[(int) file.length()];
        Image image = Image.builder().name("IMG_1338~photo.jpg").data(fileByte).build();
        iMageDBRepo.save(image);
    }

    /**
     *
     * @throws IOException
     * If the Image is to large and unable to retrieve from the DB then execute the below query in DB <br/>
     * set global max_allowed_packet=32*1024*1024;
     */
    @Disabled
    @Test
    public void testReadImageBLOB() throws IOException {
        Image image = iMageDBRepo.findById(1).get();
        FileOutputStream outputStream = new FileOutputStream(new File("E:\\Test-Image\\download\\" + image.getName()));
        outputStream.write(image.getData());
        outputStream.flush();
        outputStream.close();
    }
}