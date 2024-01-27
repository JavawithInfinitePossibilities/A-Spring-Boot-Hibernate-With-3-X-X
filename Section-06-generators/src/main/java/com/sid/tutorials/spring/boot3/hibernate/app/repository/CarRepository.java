package com.sid.tutorials.spring.boot3.hibernate.app.repository;

import com.sid.tutorials.spring.boot3.hibernate.app.entity.CarEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author kunmu On 30-12-2023
 */
@Repository
public interface CarRepository extends CrudRepository<CarEntity, Integer> {
}
