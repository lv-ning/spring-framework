package com.spring.lifecycle.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author nning_l@163.com
 * @since 2022-03-27
 */
@Aspect
@Component
@Slf4j
public class NotVeryUsefulAspect {

	@Pointcut("within(com.spring.lifecycle.bean.A)")
	private void pointcut() {}

	@Before("pointcut()")
	public void before() {

		log.debug("aop before");
	}
}
