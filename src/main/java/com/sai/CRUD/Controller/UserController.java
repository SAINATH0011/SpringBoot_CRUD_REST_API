package com.sai.CRUD.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sai.CRUD.Jpa.User;
import com.sai.CRUD.Repository.UserRepository;
import com.sai.CRUD.Service.UserService;

import lombok.AllArgsConstructor;

@RestController


public class UserController {
    
	@Autowired
	private UserService userService;
	
	//Build Create User Rest Api
	
	//This will Save the data
	@PostMapping("/sai/save")
	public ResponseEntity<User> createUser(@RequestBody User user)
	{
	  User saveUser =userService.createUser(user);
		System.out.println(user);
		return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
	}
	
	//This Will Return Single Row 
	@GetMapping("{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id)
	{
		User user = userService.getUserById(id);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	//This will Return All Users Row Records
	@GetMapping("/AllUsers")
	public ResponseEntity<List<User>> getAllUsers()
	{
		List<User> users = userService.getAllUsers();
		
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
	
	//This is Update the data
	@PutMapping("/{id}")
	public ResponseEntity<User> update(@PathVariable Long id ,@RequestBody  User user)
	{
		       user.setId(id);
		User updateUser = userService.update(user);
		return new ResponseEntity<>(updateUser,HttpStatus.OK);
	}
	
	//This Will Delete User According to Id
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteuser(@PathVariable Long id)
	{
		userService.deleteUser(id);
		
		return new ResponseEntity<>("User Deleted!",HttpStatus.OK);
		}
	}
