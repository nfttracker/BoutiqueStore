package com.mascene.dao;

import java.util.List;

import com.mascene.api.request.UserRequest;
import com.mascene.api.response.UserResponse;

/**
 * @author Raman.Ahuja
 * 
 *         Interface for user Data object layer
 *
 */
public interface UserDao {

	public List<UserResponse> getAllUsers();

	public UserResponse createUser(UserRequest userRequest);

	public UserResponse updateUser(UserRequest userRequest, long userId);

	public UserResponse deleteUser(long userId);
}
