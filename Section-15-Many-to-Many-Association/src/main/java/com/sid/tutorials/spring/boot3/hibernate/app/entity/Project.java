/**
 * 
 */
package com.sid.tutorials.spring.boot3.hibernate.app.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lenovo
 *
 */
@Data
@NoArgsConstructor
@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pjid;
	private String name;

	@ManyToMany(mappedBy = "projects", fetch = FetchType.LAZY)
	private List<Programmer> programmers;

	/**
	 * @param name
	 * @param programmers
	 */
	@Builder
	public Project(String name) {
		super();
		this.name = name;
	}

	public void addProgrammer(Programmer programmer) {
		if (programmer != null) {
			if (programmers == null) {
				programmers = new ArrayList<Programmer>();
			}
			programmers.add(programmer);
		}
	}

}
