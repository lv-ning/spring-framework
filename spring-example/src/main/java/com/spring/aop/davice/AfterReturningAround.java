package com.spring.aop.davice;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 返回通知
 *
 * @author nning_l@163.com
 * @since 2023-07-11
 */
@Slf4j
public class AfterReturningAround implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object proceed = invocation.proceed();
		log.debug("after returning around");
		return proceed;
	}
}
