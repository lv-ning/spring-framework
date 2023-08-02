package com.spring.introspect.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author nning_l@163.com
 * @since 2022-07-27
 */
@Slf4j
@Component(value = "springBean")
public class SpringBeanDemo {

	/**
	 * 属性注入
	 */
	@Autowired
	private AnnotationAutowiredBeanInfoDemo annotationAutowiredBeanInfoDemo;

	/**
	 * 手动注入
	 */
	@Autowired
	public void setAnnotationAutowiredMethodBeanInfoDemo(AnnotationAutowiredMethodBeanInfoDemo annotationAutowiredMethodBeanInfoDemo) {
		log.debug("手动注入 : {}", annotationAutowiredMethodBeanInfoDemo);
	}

	/**
	 * 自动注入
	 */
	public void setAutowiredInjectByTypeMethodBeanDemo(AutowiredInjectByTypeMethodBeanDemo autowiredInjectByTypeMethodBeanDemo) {
		log.debug("自动注入 ： {}", autowiredInjectByTypeMethodBeanDemo);
	}

	/**
	 * beanDefinition getPropertyValues 方法设置
	 */
	public void setBeanDefinitionPropertyValuesBeanDemo(BeanDefinitionPropertyValuesBeanDemo beanDefinitionPropertyValuesBeanDemo) {
		log.debug("bean definition 注入 : {}", beanDefinitionPropertyValuesBeanDemo);
	}

	public void printF() {
		log.debug("属性注入 ： {}", annotationAutowiredBeanInfoDemo);
	}
}
