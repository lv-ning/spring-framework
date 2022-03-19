package com.spring.context.bdpp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author nning_l@163.com
 * @since 2022-03-19
 */
@Component
@Slf4j
public class D implements BeanDefinitionRegistryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		// beanFactory 只能修改
		log.debug("d-p scan parent postProcessBeanFactory");
	}

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		// registry 可以动态添加
		log.debug("d-s scan subclass postProcessBeanDefinitionRegistry registry E F");
		BeanDefinitionBuilder e = BeanDefinitionBuilder.genericBeanDefinition(E.class);
		registry.registerBeanDefinition("e", e.getBeanDefinition());
		BeanDefinitionBuilder f = BeanDefinitionBuilder.genericBeanDefinition(F.class);
		registry.registerBeanDefinition("f", f.getBeanDefinition());
	}
}
