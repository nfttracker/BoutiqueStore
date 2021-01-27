package com.mascene.dao;

import java.util.List;

import com.mascene.api.request.ProductRequest;
import com.mascene.api.response.ProductResponse;

/**
 * @author Raman.Ahuja
 * 
 *         Interface for product Data object layer
 *
 */
public interface ProductDao {

	public List<ProductResponse> getAllProducts();

	public ProductResponse createProduct(ProductRequest productRequest);

	public ProductResponse updateProduct(ProductRequest productRequest, long productId);

	public ProductResponse deleteProduct(long productId);

}
