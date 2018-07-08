package com.neusoft.serviceImpl;

import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.entity.Role;
import com.neusoft.entity.User;
import com.neusoft.repository.RoleRepository;
import com.neusoft.repository.UserRepository;
import com.neusoft.service.ILoginService;

@Service
@Transactional
public class LoginServiceImpl implements ILoginService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public Role addRole(Map<String, Object> map) {
		
		Role role = new Role();
		role.setName(map.get("roleName").toString());
		roleRepository.save(role);
		
		return role;
	}

	@Override
	public User addUser(Map<String, Object> map) {
		User user = new User();
		user.setName(map.get("username").toString());
		user.setPassWord(map.get("password").toString());
		userRepository.save(user);
		return user;
	}

	@Override
	public User findByName(String name) {
		 return userRepository.findByName(name);
	}

}
