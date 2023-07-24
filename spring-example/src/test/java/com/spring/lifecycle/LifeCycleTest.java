package com.spring.lifecycle;

import com.spring.lifecycle.bean.D;
import com.spring.lifecycle.bean.E;
import com.spring.lifecycle.bean.F;
import com.spring.lifecycle.config.LifeCycleConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * TODO
 *
 * @author nning_l@163.com
 * @since 2022-03-27
 */
public class LifeCycleTest {

	@Test
	public void testJdkProxy() {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(LifeCycleConfig.class);
		context.getBean(D.class).m0();
		context.getBean(F.class).m0();
	}
}
