/**
 * 
 */
package com.sid.tutorials.spring.boot3.hibernate.app.repositories;

import com.sid.tutorials.spring.boot3.hibernate.app.model.db.Payment;
import org.springframework.data.repository.CrudRepository;

/**
 * @author kunmu
 *
 */
public interface IPaymentRepo extends CrudRepository<Payment, Integer> {

}
