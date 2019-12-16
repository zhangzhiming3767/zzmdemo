package com.example.zzmdemo.shiro;

import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.ArrayList;
import java.util.List;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2019 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *   AuthorizingRealm  extends  AuthorizingRealm
 * @author zhangzhiming
 * @since 2019/12/13 10:13
 */
public class ManageAuthority extends AuthorizingRealm {
    /***
     * 授权.
     * @param principals principals
     * @return AuthorizationInfo
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            final PrincipalCollection principals) {
        String currentUsername
                = (String) super.getAvailablePrincipal(principals);

        /**角色名称列表*/
        List<String> rolestr = new ArrayList<String>();

        /**权限标识列表**/
        List<String> permissionstr = new ArrayList<String>();
        permissionstr.add("test1");
        permissionstr.add("test2");

        SimpleAuthorizationInfo simpleAuthorInfo
                = new SimpleAuthorizationInfo();
        simpleAuthorInfo.addRoles(rolestr);
        simpleAuthorInfo.addStringPermissions(permissionstr);
        return simpleAuthorInfo;
    }

    /***
     * 认证.
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            final AuthenticationToken authcToken) throws ShiroException {
            AuthenticationInfo authcInfo
                    = new SimpleAuthenticationInfo(
                  "LoginName", "getPassword",
                    ByteSource.Util.bytes("user.getSalt"), getName()
            );
            return authcInfo;
    }
}
