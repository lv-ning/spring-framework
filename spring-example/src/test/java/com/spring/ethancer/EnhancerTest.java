package com.spring.ethancer;

import com.spring.ethancer.config.AppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.support.ResourcePropertySource;

/**
 * TODO
 *
 * @author nning_l@163.com
 * @since 2022-04-18
 */
public class EnhancerTest {

	@Test
	public void defaultTest() throws Exception {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext();
		context.register(AppConfig.class);

//		ConfigurableEnvironment environment = context.getEnvironment();
//		ResourcePropertySource propertySource = new ResourcePropertySource("classpath:application.properties");
//		environment.getPropertySources().addLast(propertySource);

		context.refresh();
	}
}
