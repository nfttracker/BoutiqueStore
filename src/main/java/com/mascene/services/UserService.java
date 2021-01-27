package com.mascene.services;

import java.util.List;

import com.mascene.api.request.UserRequest;
import com.mascene.api.response.UserResponse;

/**
 * @author Raman.Ahuja
 * 
 *         User Entity Service Interface for database CRUD layer interaction
 *
 */
public interface UserService {

	public List<UserResponse> getUsers();

	public UserResponse createUser(UserRequest userRequest);

	public UserResponse updateUser(UserRequest userRequest, long userId);

	public UserResponse deleteUser(long userId);

}
