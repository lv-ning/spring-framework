package com.spring.aop.davice;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ReflectiveMethodInvocation;

/**
 * 通知
 *
 * @author nning_l@163.com
 * @since 2022-07-06
 */
@Slf4j
public class AfterAround implements MethodInterceptor {

	/**
	 * 为什么传这个对象 MethodInvocation
	 * 为了执行下一个增强器
	 * 递归调用
	 *
	 * @param invocation the method invocation joinpoint
	 * @see ReflectiveMethodInvocation
	 */
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		try {
			return invocation.proceed();
		} finally {
			log.debug("after around");
		}
	}
}
