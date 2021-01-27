package com.mascene.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mascene.api.request.ProductRequest;
import com.mascene.api.response.ProductResponse;
import com.mascene.dao.ProductDao;
import com.mascene.services.ProductService;

/**
 * @author Raman.Ahuja
 * 
 *         Product Entity Service implementation for database CRUD layer
 *         interaction
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;

	@Override
	public List<ProductResponse> getProducts() {
		return productDao.getAllProducts();
	}

	@Override
	public ProductResponse createProduct(ProductRequest productRequest) {
		ProductResponse productResponse = productDao.createProduct(productRequest);
		if (productResponse != null) {
			return productResponse;
		}
		productResponse = new ProductResponse();
		productResponse.setApiResponseMessage("Failure in product creation");
		productResponse.setApiResponseStatus(Boolean.FALSE);
		return productResponse;
	}

	@Override
	public ProductResponse updateProduct(ProductRequest productRequest, long productId) {
		ProductResponse productResponse = productDao.updateProduct(productRequest, productId);
		if (productResponse != null) {
			return productResponse;
		}
		productResponse = new ProductResponse();
		productResponse.setApiResponseMessage("Failure in product updation");
		productResponse.setApiResponseStatus(Boolean.FALSE);
		return productResponse;
	}

	@Override
	public ProductResponse deleteProduct(long productId) {
		ProductResponse productResponse = productDao.deleteProduct(productId);
		if (productResponse != null) {
			return productResponse;
		}
		productResponse = new ProductResponse();
		productResponse.setProductId(productId);
		productResponse.setApiResponseMessage("Product doesn't exists with Order Id: " + productId);
		productResponse.setApiResponseStatus(Boolean.FALSE);
		return productResponse;
	}

}
