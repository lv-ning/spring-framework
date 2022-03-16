package com.spring.automodel.di;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * TODO
 *
 * @author nning_l@163.com
 * @since 2022-03-07
 */
public class DependsTest {

	@Test
	public void dependTest() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.spring.automodel.depends");
		context.refresh();
	}
}
