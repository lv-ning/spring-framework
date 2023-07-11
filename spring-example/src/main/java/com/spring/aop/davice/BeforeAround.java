package com.spring.aop.davice;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 之前通知
 *
 * @author nning_l@163.com
 * @since 2023-07-11
 */
@Slf4j
public class BeforeAround implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		log.debug("before around");
		return invocation.proceed();
	}
}
