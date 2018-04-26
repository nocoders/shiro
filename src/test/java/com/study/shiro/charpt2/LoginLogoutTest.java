package com.study.shiro.charpt2;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.util.ThreadContext;
import org.junit.After;
import org.junit.Test;

import junit.framework.Assert;

public class LoginLogoutTest {
	@Test
	public void testHelloWorld() {
		Factory<SecurityManager>factory=new IniSecurityManagerFactory("classpath:shiro.ini");
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhang","123");
		try {
			subject.login(token);
			System.out.println("登录成功");

		} catch (AuthenticationException e) {
			System.out.println("用户名或密码错误");

		}
		Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录
		subject.logout();
	}
	@Test
	public void testCustomRealm() {
		Factory<SecurityManager>factory = new IniSecurityManagerFactory("classpath:shiro-realm.ini");
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
		try {
			subject.login(token);
			System.out.println("登陆成功");

		} catch (AuthenticationException e) {
			e.printStackTrace();
			System.out.println("登录失败");

		}
		
		Assert.assertEquals(true, subject.isAuthenticated());
		subject.logout();
	}
	/**
	 * 多realm配置时，只要有一个realm是正确的，就会成功
	 */
	@Test
	public void testCustomMultiRealm() {
		Factory<SecurityManager>factory=new IniSecurityManagerFactory("classpath:shiro-multi-realm.ini");
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Assert.assertEquals(true, subject.isAuthenticated());
		subject.logout();
	}
	@Test
	public void testJDBCRealm() {
		Factory<SecurityManager>factory=new IniSecurityManagerFactory("classpath:shiro-jdbc-realm.ini");
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Assert.assertEquals(true, subject.isAuthenticated());
		subject.logout();
	}
	@After
	public void tearDown() throws Exception{
		ThreadContext.unbindSubject();
	}
}
