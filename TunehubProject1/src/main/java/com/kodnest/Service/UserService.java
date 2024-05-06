package com.kodnest.Service;

import org.springframework.stereotype.Service;

import com.kodnest.Entity.User;
@Service
public interface UserService {

	 void saveUser(User user);
	boolean emailExists(User user);
	boolean validUser(String email, String password);
	String getRole(String email);
	User getUser(String mail);
	void updateUser(User user);
}
