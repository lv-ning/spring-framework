package com.spring.ethancer;

import com.spring.ethancer.config.AppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * TODO
 *
 * @author nning_l@163.com
 * @since 2022-04-18
 */
public class EnhancerTest {

	@Test
	public void defaultTest() {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(AppConfig.class);

		ConfigurableEnvironment environment = context.getEnvironment();
	}
}
