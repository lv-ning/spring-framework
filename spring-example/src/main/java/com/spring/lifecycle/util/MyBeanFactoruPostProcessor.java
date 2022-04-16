package com.spring.lifecycle.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author nning_l@163.com
 * @since 2022-03-27
 */
@Component
public class MyBeanFactoruPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		AbstractBeanDefinition a = (AbstractBeanDefinition) beanFactory.getBeanDefinition("a");
		// 自动注入
		a.setAutowireMode(AbstractBeanDefinition.DEPENDENCY_CHECK_SIMPLE);
	}
}
