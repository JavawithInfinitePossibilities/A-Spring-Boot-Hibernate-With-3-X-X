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
public class Programmer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pgrmid;
    private String name;
    private int salary;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "programmer_project", joinColumns = @JoinColumn(referencedColumnName = "pgrmid"),
            inverseJoinColumns = @JoinColumn(referencedColumnName = "pjid"))
    private List<Project> projects;

    /**
     * @param name
     * @param salary
     * @param projects
     */
    @Builder
    public Programmer(String name, int salary) {
        super();
        this.name = name;
        this.salary = salary;
    }

    public void addProject(Project project) {
        if (project != null) {
            if (projects == null) {
                projects = new ArrayList<Project>();
            }
            projects.add(project);
        }
    }

}
