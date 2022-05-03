package com.joyner.gp_learning.orm_related.mybatis.plugins;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.lang.invoke.MethodHandle;
import java.lang.reflect.Method;
import java.sql.Connection;

/**
 * <pre>
 * 自定义插件，对使用了RowBounds查询的sql进行实际的物理分页
 * </pre>
 *
 * @author 陆清云 luqingyun@foresee.cn
 * @version 1.00.00
 * MappedStatement ms, Object parameter, RowBounds rowBounds, ResultHandler resultHandler, CacheKey cacheKey, BoundSql boundSql
 * <pre>
 * 修改记录
 * 修改后版本: 修改人： 修改日期: 修改内容:
 * </pre>
 */
@Intercepts({
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})
})
public class PhysicalRowBoundsInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        /**
         * 1.获取原来的BoundSql、RowBounds
         * 2.获取sql,根据RowBounds生成分页sql,构造一个新的BoundSql
         * 3.使用BoundSql作为参数去调用Executor的query方法（6个参数的）
         */
        RowBounds originalRowBounds = (RowBounds)invocation.getArgs()[2];
        Object[] args = invocation.getArgs();
        MappedStatement mappedStatement = (MappedStatement) args[0];
        Object parameter = invocation.getArgs()[1];
        

        ResultHandler resultHandler = (ResultHandler) args[3];
        BoundSql originalBoundSql = mappedStatement.getBoundSql(parameter);
        String originalSql = originalBoundSql.getSql();

        //构造新的BoundSql
        String pageSql = originalSql + " limit " + originalRowBounds.getOffset() + "," + originalRowBounds.getLimit();
        BoundSql newBoundSql = new BoundSql(mappedStatement.getConfiguration(), pageSql, originalBoundSql.getParameterMappings(), originalBoundSql.getParameterObject());

        //获取6个参数的query方法
        Method _6ParametersMethod = invocation.getTarget().getClass().getMethod("query", MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class);


        //不使用分页逻辑分页
        RowBounds newRowBounds = new RowBounds();

        CacheKey cacheKey = null;
        if (args.length == 6) {
            cacheKey =  (CacheKey)args[4];
        } else {
            //模拟原来方法的逻辑，4个参数的方法最终会调用6个参数的方法
            //获取createCacheKey方法
            Method createCacheKeyMethod = invocation.getTarget().getClass().getMethod("createCacheKey", MappedStatement.class, Object.class, RowBounds.class, BoundSql.class);
            //调用创建cacheKey方法
            cacheKey = (CacheKey) createCacheKeyMethod.invoke(invocation.getTarget(), mappedStatement, parameter, newRowBounds, newBoundSql);
        }

        //调用6个参数的方法
        Object result = _6ParametersMethod.invoke(invocation.getTarget(), mappedStatement, parameter, newRowBounds, resultHandler, cacheKey, newBoundSql);
        return result;
    }

}
