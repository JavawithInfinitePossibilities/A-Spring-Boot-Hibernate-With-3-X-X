package com.sid.tutorials.spring.boot3.hibernate.app.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "Car")
public class CarEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "make_description")
	private String make;
	private String model;
	private String color;
	private Integer year;
	private Double price;
}
