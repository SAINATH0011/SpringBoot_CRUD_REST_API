package com.sai.CRUD.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sai.CRUD.Jpa.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	

}
