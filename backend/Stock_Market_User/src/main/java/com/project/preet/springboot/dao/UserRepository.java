package com.project.preet.springboot.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.preet.springboot.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	
	
	Optional<User> findByUserNameAndPassword(String userName,String password);

	


}
