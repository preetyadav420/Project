package com.project.preet.springboot.dto;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	
	int Id;
	
	String userName;

	String password;

	String userType;

	String email;

	String mobile;

	boolean confirmed;

}
