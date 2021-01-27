package com.mascene.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mascene.entities.CustomerOrder;

/**
 * @author Raman.Ahuja
 * 
 *         Order Entity CRUD Repository
 *
 */
@Repository
public interface OrderRepository extends CrudRepository<CustomerOrder, Long> {

}
