package com.study.shiro.charpt2.authenticator;

import java.util.Collection;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.pam.AbstractAuthenticationStrategy;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.util.CollectionUtils;

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
		return new SimpleAuthenticationInfo();
	}
/**
 * 每个realm之前调用
 */
	@Override
	public AuthenticationInfo beforeAttempt(Realm realm, AuthenticationToken token, AuthenticationInfo aggregate)
			throws AuthenticationException {
		// TODO Auto-generated method stub
		return aggregate;
	}
/**
 * 每个realm之后调用
 */
	@Override
	public AuthenticationInfo afterAttempt(Realm realm, AuthenticationToken token, AuthenticationInfo singleRealmInfo,
			AuthenticationInfo aggregateInfo, Throwable t) throws AuthenticationException {
		AuthenticationInfo info;
		if (singleRealmInfo==null) {
			info=aggregateInfo;
		}else {
			if (aggregateInfo==null) {
				info=singleRealmInfo;
			}else {
				info=merge(singleRealmInfo, aggregateInfo);
			}
		}
		return info;
	}
/**
 * 所有realm之后调用
 */
	@Override
	public AuthenticationInfo afterAllAttempts(AuthenticationToken token, AuthenticationInfo aggregate)
			throws AuthenticationException {
		if (aggregate==null||CollectionUtils.isEmpty(aggregate.getPrincipals())||aggregate.getPrincipals().getRealmNames().size()<2) {
			throw new AuthenticationException("Authentication token of type ["+token.getClass()+"]"+
					"could not be authenticated by any configure realms. Please ensure that at least two realm can " +
					"authenticate these tokens.");
		}
		return aggregate;
	}
	
}
