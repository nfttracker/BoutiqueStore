package com.mascene.services;

import java.util.List;

import com.mascene.api.request.ProductRequest;
import com.mascene.api.response.ProductResponse;

/**
 * @author Raman.Ahuja
 * 
 *         Product Entity Service Interface for database CRUD layer interaction
 *
 */
public interface ProductService {

	public List<ProductResponse> getProducts();

	public ProductResponse createProduct(ProductRequest productRequest);

	public ProductResponse updateProduct(ProductRequest productRequest, long productId);

	public ProductResponse deleteProduct(long productId);

}
