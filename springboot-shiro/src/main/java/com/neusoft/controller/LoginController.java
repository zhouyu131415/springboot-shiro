package com.neusoft.controller;

import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.entity.User;
import com.neusoft.service.ILoginService;

@RestController
public class LoginController {
	
	@Autowired
	private ILoginService loginService;
	
	@RequestMapping(value = "/static/login", method = RequestMethod.POST)
	public String login(@RequestParam String username, @RequestParam String password) {
		//添加用户认证信息
		Subject subject = SecurityUtils.getSubject();
//		String name = map.get("username").toString();
//		String password = map.get("password").toString();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		
		subject.login(token);
		return "login";
	}
	
	@RequestMapping(value = "/static/addUser", method = RequestMethod.POST)
	public String addUser(@RequestParam String username, @RequestParam String password) {
		return "addUser";
	}
	
	@RequestMapping("/unauth")
	public String addRole(@RequestParam String username, @RequestParam String password) {
		return "unauth";
	}
	
	
}
