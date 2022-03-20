package com.spring.context.bdpp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * TODO
 *
 * @author nning_l@163.com
 * @since 2022-03-19
 */
@Slf4j
public class B implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		log.debug("b-p api parent postProcessBeanFactory");
//		beanFactory.ignoreDependencyType();
//		beanFactory.ignoreDependencyInterface();
	}
}
