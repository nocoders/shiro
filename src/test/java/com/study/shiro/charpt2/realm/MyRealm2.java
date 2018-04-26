package com.study.shiro.charpt2.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;

public class MyRealm2 implements Realm{

	@Override
	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		// TODO Auto-generated method stub
		String username=(String)arg0.getPrincipal();
		String password=new String((char[])arg0.getCredentials());
		if (!"wang".equals(username)) {
			throw new UnknownAccountException();//用户名错误
		}
		if (!"123".equals(password)) {
			throw new IncorrectCredentialsException();
		}
		return new SimpleAuthenticationInfo(username,password,getName());
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "myrealm2";
	}

	@Override
	public boolean supports(AuthenticationToken arg0) {
		// TODO Auto-generated method stub
		return arg0 instanceof UsernamePasswordToken;
	}

}
