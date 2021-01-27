package com.mascene.api.response;

import com.mascene.entities.User;

/**
 * @author Raman.Ahuja
 *
 *         Class to get a response to the api for user CRUD operations
 *
 */
public class UserResponse extends User {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
