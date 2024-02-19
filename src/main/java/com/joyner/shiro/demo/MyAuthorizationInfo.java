package com.joyner.shiro.demo;

import lombok.Data;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

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
@Data
public class MyAuthorizationInfo implements AuthorizationInfo {

    private List<String> roleList;

    @Override
    public Collection<String> getRoles() {
        return roleList;
    }

    @Override
    public Collection<String> getStringPermissions() {
        return Arrays.asList("system:user:create,update,delete,view");
    }

    @Override
    public Collection<Permission> getObjectPermissions() {
        return null;
    }
}
