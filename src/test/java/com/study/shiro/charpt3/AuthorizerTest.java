package com.study.shiro.charpt3;

import org.junit.Test;

import junit.framework.Assert;

public class AuthorizerTest extends BaseTest{
	@Test
	public void testlsPermitted() {
		login("classpath:charpt3/shiro-authorizer.ini", "zhang", "123");
//		判断权限： user:create
		Assert.assertTrue(subject().isPermitted("user1:update"));
		Assert.assertTrue(subject().isPermitted("user2:update"));
		
		Assert.assertTrue(subject().isPermitted("+user1+2"));
		Assert.assertTrue(subject().isPermitted("+user1+8"));
		Assert.assertFalse(subject().isPermitted("+user1+4"));
	}
}
