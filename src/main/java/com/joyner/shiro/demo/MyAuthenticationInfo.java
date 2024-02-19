package com.joyner.shiro.demo;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.subject.PrincipalCollection;

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
public class MyAuthenticationInfo implements AuthenticationInfo {

    private String principals;

    private String credentials;

    MyAuthenticationInfo(String principals, String credentials) {
        this.credentials = credentials;
        this.principals = principals;
    }

    @Override
    public PrincipalCollection getPrincipals() {
        MyPrincipalCollection myPrincipalCollection = new MyPrincipalCollection();
        myPrincipalCollection.setPrimaryPrincipal(principals);
        myPrincipalCollection.setRealmName("myRealm");
        return myPrincipalCollection;
    }

    @Override
    public Object getCredentials() {
        return credentials;
    }
}
