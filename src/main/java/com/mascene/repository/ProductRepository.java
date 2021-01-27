package com.mascene.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mascene.entities.Product;

/**
 * @author Raman.Ahuja
 * 
 *         Product Entity CRUD Repository
 *
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

	public Optional<Product> findProductByProductBarcode(long productBarcode);

	public Optional<Product> deleteByProductBarcode(long productBarcode);

}
