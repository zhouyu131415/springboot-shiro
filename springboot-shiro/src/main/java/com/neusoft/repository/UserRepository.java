package com.neusoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neusoft.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByName(String name);
}
