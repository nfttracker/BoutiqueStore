package com.mascene.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mascene.api.request.ProductRequest;
import com.mascene.api.response.ProductResponse;
import com.mascene.dao.ProductDao;
import com.mascene.entities.Product;
import com.mascene.repository.ProductRepository;

/**
 * @author Raman.Ahuja
 * 
 *         Implementation for product data object layer
 *
 */
@Service
@Transactional
public class ProductDaoImpl implements ProductDao {

	@Autowired
	ProductRepository productRepository;

	@Override
	public List<ProductResponse> getAllProducts() {
		List<Product> products = (List<Product>) productRepository.findAll();
		List<ProductResponse> productResponses = new ArrayList<>();
		if (products != null) {
			for (Product product : products) {
				if (product != null) {
					ProductResponse productResponse = new ProductResponse();
					BeanUtils.copyProperties(product, productResponse);
					productResponse.setApiResponseMessage("All products fetched successfully");
					productResponse.setApiResponseStatus(Boolean.TRUE);
					productResponses.add(productResponse);
				}
			}
		}
		return productResponses;
	}

	@Override
	public ProductResponse createProduct(ProductRequest productRequest) {
		Product product = new Product();
		product.setDateAdded(new Date());
		BeanUtils.copyProperties(productRequest, product);
		Product productSaved = productRepository.save(product);
		ProductResponse productResponse = new ProductResponse();
		if (productSaved != null) {
			BeanUtils.copyProperties(productSaved, productResponse);
			productResponse.setApiResponseMessage("Product created successfully");
			productResponse.setApiResponseStatus(Boolean.TRUE);
		} else {
			productResponse.setApiResponseMessage("Failure in product creation");
			productResponse.setApiResponseStatus(Boolean.TRUE);
		}
		return productResponse;
	}

	@Override
	public ProductResponse updateProduct(ProductRequest productRequest, long productId) {
		Optional<Product> product = productRepository.findById(productId);
		Product productFetched = product.get();
		BeanUtils.copyProperties(productRequest, productFetched);
		Product productUpdated = productRepository.save(productFetched);

		ProductResponse productResponse = new ProductResponse();
		if (productUpdated != null) {
			BeanUtils.copyProperties(productUpdated, productResponse);
			productResponse.setApiResponseMessage("Product updated successfully");
			productResponse.setApiResponseStatus(Boolean.TRUE);
		} else {
			productResponse.setApiResponseMessage("Failure in product updation");
			productResponse.setApiResponseStatus(Boolean.FALSE);
		}
		return productResponse;
	}

	@Override
	public ProductResponse deleteProduct(long productId) {
		Optional<Product> product = productRepository.findById(productId);
		ProductResponse productResponse = new ProductResponse();
		if (product.get() != null) {
			BeanUtils.copyProperties(product, productResponse);
			productRepository.delete(product.get());
			productResponse.setApiResponseMessage("Product Deleted Successfully");
			productResponse.setApiResponseStatus(Boolean.TRUE);
		} else {
			productResponse.setProductId(productId);
			productResponse.setApiResponseMessage("Product doesn't exists with product Id: " + productId);
			productResponse.setApiResponseStatus(Boolean.FALSE);
		}
		return productResponse;
	}
}