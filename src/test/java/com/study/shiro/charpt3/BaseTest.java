package com.study.shiro.charpt3;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.util.ThreadContext;
import org.junit.After;
/**
 * 为其他类提供使用方法
 * @author user
 *
 */
public abstract class BaseTest {
	@After
	public void tearDown() throws Exception {
        ThreadContext.unbindSubject();//退出时请解除绑定Subject到线程 否则对下次测试造成影响
    }
	
	protected void login(String configFile,String username,String password) {
		Factory<SecurityManager>factory=new IniSecurityManagerFactory(configFile);
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username,password);
		subject.login(token);
	}

	public Subject subject() {
		// TODO Auto-generated method stub
		return SecurityUtils.getSubject();
	}
}
