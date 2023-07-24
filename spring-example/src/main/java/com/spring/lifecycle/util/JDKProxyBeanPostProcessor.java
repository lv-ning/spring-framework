package com.spring.lifecycle.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk 代理的 BeanPostProcessor
 *
 * @author nning_l@163.com
 * @since 2023-07-24
 */
//@Component
@Slf4j
public class JDKProxyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (beanName.equals("e")) {
			Class<?>[] interfaces = bean.getClass().getInterfaces();
			return Proxy.newProxyInstance(this.getClass().getClassLoader(), interfaces, new JDKProxyInvocationHandler(bean));
		}
		return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}

	private static class JDKProxyInvocationHandler implements InvocationHandler {

		private final Object target;

		public JDKProxyInvocationHandler(Object target) {
			this.target = target;
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			log.debug("before ----");
			Object obj = method.invoke(target, args);
			log.debug("after ---");
			return obj;
		}
	}
}
