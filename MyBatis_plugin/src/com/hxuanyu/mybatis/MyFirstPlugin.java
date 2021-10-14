package com.hxuanyu.mybatis;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import java.util.Properties;

/**
 * 完成插件签名，告诉插件拦截哪个对象的哪个方法
 *
 * @author hanxuanyu
 * @version 1.0
 */
@Intercepts({@Signature(
        type = StatementHandler.class,
        method = "parameterize",
        args = java.sql.Statement.class
)})
public class MyFirstPlugin implements Interceptor {

    /**
     * intercept:拦截目标对象的目标方法的执行
     * invocation：
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // 动态改变sql运行的参数
        System.out.println("当前拦截到的对象：" + invocation.getTarget());
        // 拿到Statement==>parameterHandler==>parameterObject
        MetaObject metaObject = SystemMetaObject.forObject(invocation.getTarget());
        Object value = metaObject.getValue("parameterHandler.parameterObject");
        System.out.println("sql语句用的参数：" + value);
        metaObject.setValue("parameterHandler.parameterObject", 11);
        // 执行目标方法
        System.out.println("MyFirstPlugin...intercept:" + invocation.getMethod());
        return invocation.proceed();
    }

    /**
     * plugin:包装目标对象，为目标对象创建一个代理对象
     */
    @Override
    public Object plugin(Object o) {
        Object wrap = Plugin.wrap(o, this);
        // 返回为当前方法创建的动态代理
        System.out.println("MyFirstPlugin...plugin: 将要包装的对象：" + o);
        return wrap;
    }

    /**
     * 插件注册时的property属性
     */
    @Override
    public void setProperties(Properties properties) {
        System.out.println("插件的配置信息：" + properties);
    }
}
