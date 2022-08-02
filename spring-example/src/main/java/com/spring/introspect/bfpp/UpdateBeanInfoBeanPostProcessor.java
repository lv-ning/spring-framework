package com.spring.introspect.bfpp;

import com.spring.introspect.bean.BeanDefinitionPropertyValuesBeanDemo;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author nning_l@163.com
 * @since 2022-07-27
 */
@Component
public class UpdateBeanInfoBeanPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		AbstractBeanDefinition definition = (AbstractBeanDefinition) beanFactory.getBeanDefinition("springBean");
		// 设置自动注入模型
//		definition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
		// 下面两个都可以通过 propertyValues 进行注入
//		definition.getPropertyValues().add("beanDefinitionPropertyValuesBeanDemo", beanFactory.getBean(BeanDefinitionPropertyValuesBeanDemo.class));
		definition.getPropertyValues().add("beanDefinitionPropertyValuesBeanDemo", new BeanDefinitionPropertyValuesBeanDemo());
	}
}
