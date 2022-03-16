package com.spring.automodel.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * TODO
 *
 * @author nning_l@163.com
 * @since 2022-03-06
 */
@Component
public class T {

	List<E> beanFactoryPostProcessors;

	public List<E> getBeanFactoryPostProcessors() {
		return beanFactoryPostProcessors;
	}

	@Autowired
	public void setBeanFactoryPostProcessors(List<E> beanFactoryPostProcessors) {
		this.beanFactoryPostProcessors = beanFactoryPostProcessors;
	}
}
