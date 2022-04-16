package com.spring.lifecycle.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 生命周期
 * 手动注入优先于自动注入
 * 自动注入使用的是 Java 的 内省 机制
 *
 * @author nning_l@163.com
 * @since 2022-03-27
 */
@Slf4j
@Component
public class A implements BeanNameAware, ApplicationContextAware, InitializingBean {

	public A() {

		log.debug("A create constructor");
	}

	@Autowired
	private B field;

	private C c;

	public void mB() {

		log.debug("a mB: {{}}", field);
	}

	public void setC(C c) {
		log.debug("byType wired : {{}}", c);
		this.c = c;
	}

	@Override
	public void setBeanName(String name) {

		log.debug("setBeanName : {{}}", name);
	}

	@PostConstruct
	public void postInit() {

		log.debug("PostConstruct init lifecycle");
	}

	@Override
	public void afterPropertiesSet() throws Exception {

		log.debug("afterPropertiesSet init lifecycle");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

		log.debug("setApplicationContext applicationContext : {{}}", applicationContext);
	}
}
