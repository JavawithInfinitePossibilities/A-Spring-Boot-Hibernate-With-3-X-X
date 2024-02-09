package com.sid.tutorials.spring.boot3.hibernate.app.repository;

import com.sid.tutorials.spring.boot3.hibernate.app.entity.CarEntity;
import com.sid.tutorials.spring.boot3.hibernate.app.entity.dto.CarDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author kunmu On 30-12-2023
 */
@Repository
public interface CarRepository extends JpaRepository<CarEntity, Integer>, PagingAndSortingRepository<CarEntity, Integer> {
    List<CarEntity> findByMake(String make);

    @Query("select new com.sid.tutorials.spring.boot3.hibernate.app.entity.dto.CarDto(ce.id,ce.make,ce.model,ce.color) from CarEntity ce where ce.make=:maker")
    public List<CarDto> getAllCarDetailsByNameSortbyYear(@Param("maker") String make, Pageable pageable);
}
