package com.study.shiro.charpt3.permission;

import java.util.Arrays;
import java.util.Collection;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.RolePermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;
/**
 * 根据字符串解析得到权限集合
 * 如果用户拥有role1，就返回一个menu：*的权限
 * @author user
 *
 */
public class MyRolePermissionResolver implements RolePermissionResolver{

	@Override
	public Collection<Permission> resolvePermissionsInRole(String roleString) {
		  if("role1".equals(roleString)) {
	            return Arrays.asList((Permission)new WildcardPermission("menu:*"));
	        }
	        return null;
	}

}
