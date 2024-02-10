/**
 * 
 */
package com.sid.tutorials.spring.boot3.hibernate.app.repository;

import com.sid.tutorials.spring.boot3.hibernate.app.entity.License;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Lenovo
 *
 */
public interface ILicenseRepo extends CrudRepository<License, Integer> {

}
