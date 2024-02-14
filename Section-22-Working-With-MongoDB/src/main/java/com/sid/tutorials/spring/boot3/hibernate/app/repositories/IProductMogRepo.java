/**
 * 
 */
package com.sid.tutorials.spring.boot3.hibernate.app.repositories;

import com.sid.tutorials.spring.boot3.hibernate.app.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author kunmu
 *
 */
public interface IProductMogRepo extends MongoRepository<Product, String> {

}
