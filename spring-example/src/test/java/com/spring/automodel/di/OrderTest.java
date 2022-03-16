package com.spring.automodel.di;

import com.spring.automodel.order.E;
import com.spring.automodel.order.T;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * TODO
 *
 * @author nning_l@163.com
 * @since 2022-03-06
 */
public class OrderTest {

	@Test
	public void orderTest() {
		AnnotationConfigApplicationContext
				context = new AnnotationConfigApplicationContext();
		context.scan("com.spring.automodel.order");
		context.refresh();

		// 加入了 order 表示 list 会按照 order 排序
		List<E> beanFactoryPostProcessors = context.getBean(T.class).getBeanFactoryPostProcessors();
		for (E e : beanFactoryPostProcessors) {
			e.orderList();
		}
	}
}
