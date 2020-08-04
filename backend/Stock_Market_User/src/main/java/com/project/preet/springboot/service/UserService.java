package com.project.preet.springboot.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.preet.springboot.dao.UserRepository;
import com.project.preet.springboot.dto.UserDto;
import com.project.preet.springboot.model.User;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRep;
	
	ModelMapper mapper=new ModelMapper();
	
	public Iterable<UserDto> getAll()
	{
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		java.lang.reflect.Type targetListType = new TypeToken<Iterable<UserDto>>() {}.getType();
			  return mapper.map(userRep.findAll(),targetListType);
	}
	
	public UserDto getUserById(int id)
	{
		
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(userRep.findById(id).get(),UserDto.class);
	}
	
	public UserDto getUserByUserName(String userName,String password)
	{
		
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(userRep.findByUserNameAndPassword(userName, password).get(),UserDto.class);
	}
	
	public void insertUser(UserDto userDto)
	{
		
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		userRep.save(mapper.map(userDto,User.class));
	}
	
	public void updateUser(UserDto userDto,int id)
	{
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		userRep.save(mapper.map(userDto,User.class));
	}
	
	public void deleteUser(int id)
	{
		userRep.deleteById(id);
	}
	
	

}
