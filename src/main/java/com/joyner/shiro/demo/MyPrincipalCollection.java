package com.joyner.shiro.demo;

import lombok.Data;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.*;

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
public class MyPrincipalCollection implements PrincipalCollection {

    private String primaryPrincipal;

    private String realmName;

    @Override
    public Object getPrimaryPrincipal() {
        return primaryPrincipal;
    }

    @Override
    public <T> T oneByType(Class<T> type) {
        return null;
    }

    @Override
    public <T> Collection<T> byType(Class<T> type) {
        return null;
    }

    @Override
    public List asList() {
        return null;
    }

    @Override
    public Set asSet() {
        return null;
    }

    @Override
    public Collection fromRealm(String realmName) {
        return Arrays.asList(realmName);
    }

    @Override
    public Set<String> getRealmNames() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}