package com.mascene.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mascene.entities.User;

/**
 * @author Raman.Ahuja
 * 
 *         User Entity CRUD Repository
 *
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	public Optional<User> findUserByUserName(String userName);

	public Optional<User> deleteByUserName(String userName);

}
