package com.study.shiro.charpt2.authenticator;

import java.util.Collection;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.pam.AbstractAuthenticationStrategy;
import org.apache.shiro.realm.Realm;

/**
 * 验证，账号信息是否正确
 * @author user
 *
 */
public class AtLeastTwoAuthenticatorStrategy extends AbstractAuthenticationStrategy{
/*
 * 返回一个权限的认证信息,所有realm验证之前调用
*/	
	@Override
	public AuthenticationInfo beforeAllAttempts(Collection<? extends Realm> realms, AuthenticationToken token)
			throws AuthenticationException {
		// TODO Auto-generated method stub
		return super.beforeAllAttempts(realms, token);
	}
/**
 * 每个realm之前调用
 */
	@Override
	public AuthenticationInfo beforeAttempt(Realm realm, AuthenticationToken token, AuthenticationInfo aggregate)
			throws AuthenticationException {
		// TODO Auto-generated method stub
		return super.beforeAttempt(realm, token, aggregate);
	}
/**
 * 每个realm之后调用
 */
	@Override
	public AuthenticationInfo afterAttempt(Realm realm, AuthenticationToken token, AuthenticationInfo singleRealmInfo,
			AuthenticationInfo aggregateInfo, Throwable t) throws AuthenticationException {
		// TODO Auto-generated method stub
		return super.afterAttempt(realm, token, singleRealmInfo, aggregateInfo, t);
	}
/**
 * 所有realm之后调用
 */
	@Override
	public AuthenticationInfo afterAllAttempts(AuthenticationToken token, AuthenticationInfo aggregate)
			throws AuthenticationException {
		// TODO Auto-generated method stub
		return super.afterAllAttempts(token, aggregate);
	}
	
}
