package com.project.preet.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Tables;
import javax.persistence.Table;

/*

UserEntity class: User login details 
1.	Id
2.	Username
3.	Password
4.	UserType(if Admin or normal User)
5.	E-mail
6.	Mobile number
7.	Confirmed

 */


@Entity
@Table( schema = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int Id;
	
	@Column(name="username")
	String userName;
	
	@Column(name="password")
	String password;
	
	@Column(name="usertype")
	String userType;
	
	@Column(name="email")
	String email;
	
	@Column(name="mobile")
	String mobile;
	
	@Column(name="confirmed")
	boolean confirmed;
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		this.Id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public boolean isConfirmed() {
		return confirmed;
	}
	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}
	
	
	
	
}
