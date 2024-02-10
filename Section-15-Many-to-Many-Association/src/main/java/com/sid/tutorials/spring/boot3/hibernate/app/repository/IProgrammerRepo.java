/**
 * 
 */
package com.sid.tutorials.spring.boot3.hibernate.app.repository;

import com.sid.tutorials.spring.boot3.hibernate.app.entity.Programmer;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Lenovo
 *
 */
public interface IProgrammerRepo extends CrudRepository<Programmer, Integer> {

}
