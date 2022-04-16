package com.spring.batis.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;

/**
 * mapper registry bean definition
 *
 * @author nning_l@163.com
 * @since 2022-04-16
 */
public class MapperRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

	private String packageName;

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		//
	}

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		// 执行这个方法
		ClassPathMapperScan scan = new ClassPathMapperScan(registry);
		scan.doScan(packageName);
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
}
