/**
 * 
 */
package com.sid.tutorials.spring.boot3.hibernate.app.repositories;

import com.sid.tutorials.spring.boot3.hibernate.app.model.db.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * @author kunmu
 *
 */
public interface IPersonRepo extends CrudRepository<Person, Integer> {

}
