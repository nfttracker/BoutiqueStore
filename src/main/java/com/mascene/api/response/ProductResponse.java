package com.mascene.api.response;

import com.mascene.entities.Product;

/**
 * @author Raman.Ahuja
 *
 *         Class to get a response to the api for product CRUD operations
 *
 */
public class ProductResponse extends Product {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
