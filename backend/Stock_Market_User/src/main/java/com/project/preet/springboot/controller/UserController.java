package com.project.preet.springboot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.preet.springboot.dto.UserDto;
import com.project.preet.springboot.model.User;
import com.project.preet.springboot.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService uService;
	
	@RequestMapping("/User")
	Iterable<UserDto> getAll()
	{
		return uService.getAll();
		
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/User/{id}")
	UserDto getUserById(@PathVariable int id)
	{
		return uService.getUserById(id);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/UserName/{userName}/{password}")
	UserDto getUserByUserName(@PathVariable String userName,@PathVariable String password)
	{
		return uService.getUserByUserName(userName,password);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/User/{id}")
	void updateUser(@RequestBody UserDto userDto , @PathVariable int id)
	{
		uService.updateUser(userDto,id);
	}
	
	@PostMapping(value="/User")
	void insertUser(@RequestBody UserDto userDto)
	{
		uService.insertUser(userDto);
	}
	
	@DeleteMapping(value="/User/{id}")
	void deleteUser(@PathVariable int id)
	{
		uService.deleteUser(id);
	}
}
