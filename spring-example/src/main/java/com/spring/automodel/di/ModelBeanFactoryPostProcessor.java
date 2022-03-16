package com.spring.automodel.di;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;

/**
 * 注入模型查看
 *
 * @author nning_l@163.com
 * @since 2022-02-21
 */
public class ModelBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		AbstractBeanDefinition beanDefinition = (AbstractBeanDefinition) beanFactory.getBeanDefinition("a");
		System.out.println("mode : " + beanDefinition.getAutowireMode());
		// 更改注入模型，默认注入模型为 0
		beanDefinition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_CONSTRUCTOR);
		System.out.println("mode : " + beanDefinition.getAutowireMode());
	}
}
