package com.study.shiro.charpt2;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.util.ThreadContext;
import org.junit.Test;

import junit.framework.Assert;

public class AuthenticatorTest {
//	所有realm全部验证成功
	@Test
	public void testAllSuccessfulStrategySuccess() {
		login("classpath:charpt2/shiro-authenticator-all-success.ini");
		Subject subject = SecurityUtils.getSubject();
		PrincipalCollection principalCollection = subject.getPrincipals();
		Assert.assertEquals(2, principalCollection.asList().size());
	}
//	所有realm全部验证失败
	@Test(expected=UnknownAccountException.class)
	public void testAllSuccessfulStrategyWithFail() {
		login("classpath:charpt2/shiro-authenticator-all-fail.ini");
	}
//	通用化登录逻辑
	public void login(String configFile) {
		Factory<SecurityManager>factory=new IniSecurityManagerFactory(configFile);
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
		subject.login(token);
	}
	
	public void tearDown() throws Exception{
		ThreadContext.unbindSubject();
	}
}
