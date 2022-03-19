package com.spring.context;

import com.spring.context.bdpp.B;
import com.spring.context.bdpp.C;
import com.spring.context.config.ContextConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * TODO
 *
 * @author nning_l@163.com
 * @since 2022-03-19
 */
public class ContextTest {

	@Test
	public void beanDefinitionPostProcessorTest() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//		context.scan("com.spring.context.bdpp");
		context.addBeanFactoryPostProcessor(new B());
		context.addBeanFactoryPostProcessor(new C());
		context.register(ContextConfig.class);
		context.refresh();
	}
}
