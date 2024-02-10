/**
 * 
 */
package com.sid.tutorials.spring.boot3.hibernate.app.repositories;

import com.sid.tutorials.spring.boot3.hibernate.app.entity.Image;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Lenovo
 *
 */
public interface IMageDBRepo extends CrudRepository<Image, Integer> {

}
