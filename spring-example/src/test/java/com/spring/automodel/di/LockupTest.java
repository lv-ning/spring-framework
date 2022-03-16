package com.spring.automodel.di;

import com.spring.automodel.lockup.LB;
import com.spring.automodel.lockup.LC;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * TODO
 *
 * @author nning_l@163.com
 * @since 2022-03-07
 */
public class LockupTest {

	@Test
	public void lockUpTest() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.spring.automodel.lockup");
		context.refresh();
		context.getBean(LC.class).test();
		System.out.println("------------");
		context.getBean(LB.class).test();
	}
}
