package com.spring.automodel.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * TODO
 *
 * @author nning_l@163.com
 * @since 2022-03-06
 */
@Slf4j
@Order(value = 7)
@Component
public class CBeanFactoryPostProcessor extends E implements BeanFactoryPostProcessor, InitializingBean {

	public CBeanFactoryPostProcessor() {

		log.debug("bean c");
	}

	// spring 自己调用
	@PostConstruct
	public void initMethod() {

		log.debug("bean init c");
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		int orderValue = 0;
		if (this.getClass().isAnnotationPresent(Order.class)) {
			Order order = this.getClass().getAnnotation(Order.class);
			orderValue = order.value();
		}
		log.debug("c order : {}", orderValue);
	}

	@Override
	public void afterPropertiesSet() throws Exception {

		log.debug("initialize bean c");
	}
}
