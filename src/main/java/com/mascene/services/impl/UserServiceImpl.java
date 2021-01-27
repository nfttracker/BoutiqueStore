package com.mascene.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mascene.api.request.UserRequest;
import com.mascene.api.response.UserResponse;
import com.mascene.dao.UserDao;
import com.mascene.services.UserService;

/**
 * @author Raman.Ahuja
 * 
 *         User Entity Service implementation for database CRUD layer
 *         interaction
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public List<UserResponse> getUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public UserResponse createUser(UserRequest userRequest) {
		UserResponse userResponse = userDao.createUser(userRequest);
		if (userResponse != null) {
			return userResponse;
		}
		userResponse = new UserResponse();
		userResponse.setApiResponseMessage("Failure in user creation");
		userResponse.setApiResponseStatus(Boolean.FALSE);
		return userResponse;
	}

	@Override
	public UserResponse updateUser(UserRequest userRequest, long userId) {
		UserResponse userResponse = userDao.updateUser(userRequest, userId);
		if (userResponse != null) {
			return userResponse;
		}
		userResponse = new UserResponse();
		userResponse.setApiResponseMessage("Failure in user updation");
		userResponse.setApiResponseStatus(Boolean.FALSE);
		return userResponse;
	}

	@Override
	public UserResponse deleteUser(long userId) {
		UserResponse userResponse = userDao.deleteUser(userId);
		if (userResponse != null) {
			return userResponse;
		}
		userResponse = new UserResponse();
		userResponse.setUserId(userId);
		userResponse.setApiResponseMessage("User doesn't exists with Order Id: " + userId);
		userResponse.setApiResponseStatus(Boolean.FALSE);
		return userResponse;
	}

}
