package com.neusoft.service;

import java.util.Map;

import com.neusoft.entity.Role;
import com.neusoft.entity.User;

public interface ILoginService {
	
	public Role addRole(Map<String, Object> map);
	
	public User addUser(Map<String, Object> map);
	
	public User findByName(String name);
}
