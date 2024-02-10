/**
 * 
 */
package com.sid.tutorials.spring.boot3.hibernate.app.repositories;

import com.sid.tutorials.spring.boot3.hibernate.app.model.db.Vehicle;
import org.springframework.data.repository.CrudRepository;

/**
 * @author kunmu
 *
 */
public interface IVehicleRepo extends CrudRepository<Vehicle, Integer> {

}
