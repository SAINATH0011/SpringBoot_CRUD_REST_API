package com.sai.CRUD.Service;

import java.util.List;

import com.sai.CRUD.Jpa.User;

public interface UserService {

	User createUser(User user);

	User getUserById(Long id);

	List<User> getAllUsers();

	User update(User user);

	void deleteUser(Long id);
		
	
}
