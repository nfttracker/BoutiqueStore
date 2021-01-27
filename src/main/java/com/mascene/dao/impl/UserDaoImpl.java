package com.mascene.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mascene.api.request.UserRequest;
import com.mascene.api.response.UserResponse;
import com.mascene.dao.UserDao;
import com.mascene.entities.User;
import com.mascene.repository.UserRepository;

/**
 * @author Raman.Ahuja
 * 
 *         Implementation for user data object layer
 *
 */
@Service
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	UserRepository userRepository;

	@Override
	public List<UserResponse> getAllUsers() {
		List<User> users = (List<User>) userRepository.findAll();
		List<UserResponse> userResponses = new ArrayList<>();
		if (users != null) {
			for (User user : users) {
				if (user != null) {
					UserResponse userResponse = new UserResponse();
					BeanUtils.copyProperties(user, userResponse);
					userResponses.add(userResponse);
				}
			}
		}
		return userResponses;
	}

	@Override
	public UserResponse createUser(UserRequest userRequest) {
		User user = new User();
		BeanUtils.copyProperties(userRequest, user);
		user.setDateAdded(new Date());
		User userSaved = userRepository.save(user);
		UserResponse userResponse = new UserResponse();
		if (userSaved != null) {
			BeanUtils.copyProperties(userSaved, userResponse);
			userResponse.setApiResponseMessage("User created successfully");
			userResponse.setApiResponseStatus(Boolean.TRUE);
		} else {
			userResponse.setApiResponseMessage("Failure in user creation");
			userResponse.setApiResponseStatus(Boolean.FALSE);
		}
		return userResponse;
	}

	@Override
	public UserResponse updateUser(UserRequest userRequest, long userId) {
		Optional<User> user = userRepository.findById(userId);
		User userFetched = user.get();
		UserResponse userResponse = new UserResponse();
		if (userFetched != null) {
			BeanUtils.copyProperties(userRequest, userFetched);
			User userUpdated = userRepository.save(userFetched);
			BeanUtils.copyProperties(userUpdated, userResponse);
			userResponse.setApiResponseMessage("User updated successfully");
			userResponse.setApiResponseStatus(Boolean.TRUE);
		} else {
			userResponse.setApiResponseMessage("Failure in user updation");
			userResponse.setApiResponseStatus(Boolean.FALSE);
		}
		return userResponse;
	}

	@Override
	public UserResponse deleteUser(long userId) {
		Optional<User> userFetched = userRepository.findById(userId);
		UserResponse userResponse = new UserResponse();
		if (userFetched.get() != null) {
			BeanUtils.copyProperties(userFetched.get(), userResponse);
			userRepository.delete(userFetched.get());
			userResponse.setApiResponseMessage("User Deleted Successfully");
			userResponse.setApiResponseStatus(Boolean.TRUE);
		} else {
			userResponse.setUserId(userId);
			userResponse.setApiResponseMessage("User doesn't exists with Order Id: " + userId);
			userResponse.setApiResponseStatus(Boolean.FALSE);
		}
		return userResponse;
	}
}
