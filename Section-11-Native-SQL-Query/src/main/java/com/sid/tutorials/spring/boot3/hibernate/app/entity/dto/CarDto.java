package com.sid.tutorials.spring.boot3.hibernate.app.entity.dto;

import lombok.*;
import org.springframework.stereotype.Component;

/**
 * @author kunmu On 10-02-2024
 */

public interface CarDto {
    public Integer getId() ;

    public String getMake() ;

    public String getModel() ;

    public String getColor();

    public Integer getYear() ;

    public Double getPrice() ;
}
