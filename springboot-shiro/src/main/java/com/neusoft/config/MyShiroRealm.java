package com.neusoft.config;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.neusoft.entity.Permission;
import com.neusoft.entity.Role;
import com.neusoft.entity.User;
import com.neusoft.service.ILoginService;

public class MyShiroRealm extends AuthorizingRealm {
	
	@Autowired
	private ILoginService loginService;
	
	@Override
	public String getName() {
		return "MyShiroRealm";
	}
	
	//授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//获取登录名
		String name = (String)principals.getPrimaryPrincipal();
		//查询用户名称
		User user = loginService.findByName(name);
		//添加角色权限
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		for(Role role : user.getRoles()) {
			//添加角色
			simpleAuthorizationInfo.addRole(role.getName());
			for(Permission permission : role.getPermissions()) {
				//添加权限
				simpleAuthorizationInfo.addStringPermission(permission.getPermission());
			}
		}
		
		return simpleAuthorizationInfo;
	}
	
	//认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		if(token.getPrincipal() == null) {
			return null;
		}
		
		//获取用户信息
		String name = token.getPrincipal().toString();
		User user = loginService.findByName(name);
		if(user == null) {
			//返回会报异常
			return null;
		} else {
			
			SimpleAuthenticationInfo simpleAuthenticationInfo  = new SimpleAuthenticationInfo(name, user.getPassWord().toString(), getName());
			return simpleAuthenticationInfo;
		}
	}

}
