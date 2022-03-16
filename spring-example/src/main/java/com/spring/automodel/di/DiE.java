package com.spring.automodel.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @see Autowired 注解
 * @see Resource 注解
 *
 * @see AutowiredAnnotationBeanPostProcessor 该类的 postProcessProperties 方法解释了 {@link Autowired} 注解的使用
 * @see CommonAnnotationBeanPostProcessor 该类的 postProcessProperties 方法解释了 {@link Resource} 注解的使用
 *
 * @author nning_l@163.com
 * @since 2022-02-22
 */
@Component
public class DiE {

	/**
	 * @see AutowiredAnnotationBeanPostProcessor
	 */
	@Autowired
	private DiF n;

	/**
	 * @see CommonAnnotationBeanPostProcessor
	 */
	@Resource
	private DiG g;

	public DiE() {
		System.out.println("默认构造方法");
	}
}
