package com.joyner.shiro.demo;

import org.apache.shiro.authc.AuthenticationToken;

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
public class MyAuthenticationToken implements AuthenticationToken {

    @Override
    public Object getPrincipal() {
        return userName;
    }

    @Override
    public Object getCredentials() {
        return password;
    }
}
