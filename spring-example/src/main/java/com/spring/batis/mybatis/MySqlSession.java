package com.spring.batis.mybatis;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Select;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 模拟 mybatis 得框架
 *
 * @author nning_l@163.com
 * @since 2022-03-13
 */
public class MySqlSession {

	/**
	 * 必须返回一个对象
	 * 对象：
	 * 1、实现clazz接口
	 * 2、实现clazz接口当中的所有方法
	 * 3、这些方法的逻辑需要完成对改方法上面的sql语句的执行
	 *
	 * @param clazz 代理对象
	 * @param <T>   生成的代理对象
	 * @return 生成的代理对象
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getMapper(Class<T> clazz) {
		ClassLoader classLoader = MySqlSession.class.getClassLoader();
		return (T) Proxy.newProxyInstance(classLoader, new Class[]{clazz}, new MyInvocationHandler());
	}

	@Slf4j
	static class MyInvocationHandler implements InvocationHandler {

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			//处理 toString、hashcode等 Object 方法
			if (method.getDeclaringClass().equals(Object.class)) {
				method.invoke(this, args);
			}

			Select select = method.getAnnotation(Select.class);
			String sql = select.value()[0];
			log.debug("假装已经连接数据库了 conn db");
			log.debug("假装执行查询 execute sql:{}", sql);
			log.debug("假装根据类型返回了真实对象----");
			return null;
		}
	}
}
