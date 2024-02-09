package com.sid.tutorials.spring.boot3.hibernate.app.entity.dto;

import lombok.*;
import org.springframework.stereotype.Component;

/**
 * @author kunmu On 10-02-2024
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Component
public class CarDto {
    private Integer id;
    private String make;
    private String model;
    private String color;
}
