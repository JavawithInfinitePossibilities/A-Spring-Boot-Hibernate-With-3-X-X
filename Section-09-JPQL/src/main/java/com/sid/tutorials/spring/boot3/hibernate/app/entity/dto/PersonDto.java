package com.sid.tutorials.spring.boot3.hibernate.app.entity.dto;

import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author kunmu On 10-02-2024
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Component
public class PersonDto implements Serializable {
    private String firstName;
    private String lastName;
}




