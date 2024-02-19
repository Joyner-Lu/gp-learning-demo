package com.joyner.shiro.demo;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.Subject;

import java.util.Arrays;

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
public class ShiroDemoTest {
    public static final String userName = "joyner";
    public static final String password = "123456";

    public static void main( String[] args ) throws Exception
    {

        System.out.println( "Hello World!" );

        DefaultSecurityManager defaultWebSecurityManager = new DefaultSecurityManager();
        Realm realm = new MyAuthorizingRealm();
        defaultWebSecurityManager.setRealms(Arrays.asList(realm));
        SecurityUtils.setSecurityManager(defaultWebSecurityManager);

        System.out.println();
        AuthenticationToken token = new MyAuthenticationToken();



        Subject currentUser = SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated()) {
            currentUser.login(token);
        }
        System.out.println("ok go go go !");
        System.out.println(currentUser.getPrincipal());

        boolean b = currentUser.hasRole("admin");

        boolean b1 = currentUser.hasRole("test");
        System.out.println(b1);


        boolean bs = currentUser.isPermittedAll("system:user:create", "system:user:update");
        System.out.println(bs);


    }
}







