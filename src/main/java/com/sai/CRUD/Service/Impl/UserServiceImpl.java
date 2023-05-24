package com.sai.CRUD.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sai.CRUD.Jpa.User;
import com.sai.CRUD.Repository.UserRepository;
import com.sai.CRUD.Service.UserService;

import lombok.AllArgsConstructor;

import com.sai.CRUD.Service.*;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	@Autowired
private UserRepository userRepository;
	
	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUserById(Long id) {
		
		Optional<User> optional = userRepository.findById(id);
		
		return optional.get();
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
		
	}

	@Override
	public User update(User user) {
		User   Excistinguser = userRepository.findById(user.getId()).get();
		
		Excistinguser.setFirstname(user.getFirstname());
		Excistinguser.setLastname(user.getLastname());
		Excistinguser.setEmail(user.getEmail());
		User updateUser = userRepository.save(Excistinguser);
		return updateUser;
	}

	@Override
	public void deleteUser(Long id) {
           userRepository.deleteById(id);		
	}

}
