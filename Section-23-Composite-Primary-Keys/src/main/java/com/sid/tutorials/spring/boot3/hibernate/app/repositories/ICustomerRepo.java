/**
 * 
 */
package com.sid.tutorials.spring.boot3.hibernate.app.repositories;

import com.sid.tutorials.spring.boot3.hibernate.app.model.componentMapping.CustomerId;
import com.sid.tutorials.spring.boot3.hibernate.app.model.db.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * @author kunmu
 *
 */
public interface ICustomerRepo extends CrudRepository<Customer, CustomerId> {

}
