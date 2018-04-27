package com.study.shiro.charpt3;

import java.util.Arrays;

import org.apache.shiro.authz.UnauthorizedException;
import org.junit.Test;

import junit.framework.Assert;

public class RoleTest extends BaseTest{
	@Test
	public void testHasRole() {
		login("classpath:charpt3/shiro-role.ini", "zhang", "123");
//		判断拥有角色role1
		Assert.assertTrue(subject().hasRole("role1"));
//		判断拥有角色role1 and role2
		Assert.assertTrue(subject().hasAllRoles(Arrays.asList("role1","role2")));
//		判断拥有角色role1 and role2 and !role3
		boolean[] result = subject().hasRoles(Arrays.asList("role1","role2","role3"));
		Assert.assertEquals(true, result[0]);
		Assert.assertEquals(true, result[1]);
		Assert.assertEquals(false, result[2]);
	}
	//	搞不懂为什么
	@Test(expected=UnauthorizedException.class)
	public void testCheckRole() {
		login("classpath:charpt3/shiro-role.ini", "zhang", "123");
//		断言拥有角色role1
		subject().checkRole("role1");
//		断言拥有角色role1 and role3
		subject().checkRoles("role1","role3");
	}
}
