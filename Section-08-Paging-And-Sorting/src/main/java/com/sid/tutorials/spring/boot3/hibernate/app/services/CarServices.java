package com.sid.tutorials.spring.boot3.hibernate.app.services;

import com.sid.tutorials.spring.boot3.hibernate.app.entity.CarEntity;
import com.sid.tutorials.spring.boot3.hibernate.app.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<CarEntity> getCarDetailsByMakeName(String make) {
        return carRepository.findByMake(make);
    }

    public List<CarEntity> getCarDetailsByMakeNamePageable(String make, Pageable pageable) {
        return carRepository.findByMake(make, pageable);
    }

    public List<CarEntity> getCarDetailsPagingAndSorting(int pageNumber, int pageSize, String columnDetails) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.ASC, columnDetails));
        Page<CarEntity> carEntities = carRepository.findAll(pageRequest);
        List<CarEntity> carEntityList = carEntities.map(carEntity -> {
            return CarEntity.builder()
                    .id(carEntity.getId())
                    .make(carEntity.getMake())
                    .model(carEntity.getModel())
                    .price(carEntity.getPrice())
                    .year(carEntity.getYear())
                    .color(carEntity.getColor())
                    .build();
        }).stream().collect(Collectors.toList());
        return carEntityList;
    }
}
