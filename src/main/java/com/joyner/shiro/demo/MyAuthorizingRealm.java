package com.joyner.shiro.demo;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.Arrays;

import static com.joyner.shiro.demo.ShiroDemoTest.password;
import static com.joyner.shiro.demo.ShiroDemoTest.userName;


/**
 * <pre>
 *
 * </pre>
 *
 * @author 陆清云 luqy@xiaopeng.com
 * @version 1.00.00
 *
 * <pre>
 * 修改记录
 * 修改后版本: 修改人： 修改日期: 修改内容:
 * </pre>
 */
public class MyAuthorizingRealm extends AuthorizingRealm {

    @Override
    public boolean supports(AuthenticationToken token) {
        boolean assignableFrom = MyAuthenticationToken.class.isAssignableFrom(token.getClass());
        return assignableFrom;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("doGetAuthenticationInfo");
        MyAuthenticationInfo myAuthenticationInfo = new MyAuthenticationInfo(userName, password);
        return myAuthenticationInfo;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Object primaryPrincipal = principals.getPrimaryPrincipal();

        MyAuthorizationInfo myAuthorizationInfo = new MyAuthorizationInfo();
        myAuthorizationInfo.setRoleList(Arrays.asList("admin"));
        return myAuthorizationInfo;
    }
}
