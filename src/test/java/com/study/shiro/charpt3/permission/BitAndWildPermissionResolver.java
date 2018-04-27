package com.study.shiro.charpt3.permission;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.PermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;
/**
 * 根据权限字符串是否以+开头来解析权限字符串为bitPermission或WildcardPermission
 * @author user
 *
 */
public class BitAndWildPermissionResolver implements PermissionResolver{

	@Override
	public Permission resolvePermission(String permissionString) {
		 if(permissionString.startsWith("+")) {
	            return new BitPermission(permissionString);
	        }
	        return new WildcardPermission(permissionString);
	}

}
