package com.study.shiro.charpt3;

import org.apache.shiro.authz.UnauthorizedException;
import org.junit.Test;

import junit.framework.Assert;

public class PermissionTest extends BaseTest{
	@Test
	public void testIsPermitted() {
		login("classpath:charpt3/shiro-permission.ini", "zhang", "123");
//		判断拥有权限：user：create
		Assert.assertTrue(subject().isPermitted("user:create"));
//		判断拥有权限：user:update user:delete
		Assert.assertTrue(subject().isPermittedAll("user:update","user:delete"));
//		判断没有权限：user:view
		Assert.assertFalse(subject().isPermitted("user:view"));
	}
	/**
	 * @author lm
	 * <p>Version:1.0
	 * <p>Date:18-4-27
	 * 加expected后，异常就不在显示，junit正确，测试时不应该加该异常，
	 * 这样才能显示出哪个断言出现错误
	 */
	@Test(expected=UnauthorizedException.class)
	public void testCheckPermission() {
		login("classpath:charpt3/shiro-permission.ini", "zhang", "123");
//		断言拥有权限 user:create
		subject().checkPermission("user:create");
//		断言拥有权限 user:delete user:update
		subject().checkPermissions("user:delete","user:update");
//		断言拥有权限 user:view 失败抛出异常
		subject().checkPermissions("user:view");
		
	}
}
