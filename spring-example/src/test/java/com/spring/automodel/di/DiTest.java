package com.spring.automodel.di;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * di 测试
 *
 * @author nning_l@163.com
 * @since 2022-02-21
 */
public class DiTest {

	@Test
	public void modelTest() throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(DiConfig.class);
		context.register(ModelBeanFactoryPostProcessor.class);
		context.refresh();
	}
}
