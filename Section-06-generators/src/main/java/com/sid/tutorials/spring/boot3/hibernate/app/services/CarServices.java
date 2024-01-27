package com.sid.tutorials.spring.boot3.hibernate.app.services;

import com.sid.tutorials.spring.boot3.hibernate.app.entity.CarEntity;
import com.sid.tutorials.spring.boot3.hibernate.app.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kunmu On 30-12-2023
 */
@Service
public class CarServices {

    @Autowired
    private CarRepository carRepository;

    public CarEntity createCarDetails(CarEntity car) {
        return carRepository.save(car);
    }

    public List<CarEntity> createCarDetailsList(List<CarEntity> car) {
        return (List<CarEntity>) carRepository.saveAll(car);
    }

    public List<CarEntity> getAllCarDetails() {
        return (List<CarEntity>) carRepository.findAll();
    }

    public CarEntity getCarDetailsById(Integer id) {
        return carRepository.findById(id).get();
    }
}
