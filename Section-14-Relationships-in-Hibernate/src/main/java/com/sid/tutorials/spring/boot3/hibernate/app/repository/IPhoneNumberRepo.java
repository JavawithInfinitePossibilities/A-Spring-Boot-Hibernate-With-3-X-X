/**
 * 
 */
package com.sid.tutorials.spring.boot3.hibernate.app.repository;

import com.sid.tutorials.spring.boot3.hibernate.app.entity.PhoneNumber;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Lenovo
 *
 */
public interface IPhoneNumberRepo extends CrudRepository<PhoneNumber, Integer> {

}
