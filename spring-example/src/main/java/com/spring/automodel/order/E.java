package com.spring.automodel.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

/**
 * TODO
 *
 * @author nning_l@163.com
 * @since 2022-03-06
 */
@Slf4j
public class E {

	public void orderList() {
		int orderValue = 0;
		if (this.getClass().isAnnotationPresent(Order.class)) {
			Order order = this.getClass().getAnnotation(Order.class);
			orderValue = order.value();
		}
		log.debug("list order postFactoryProcess : {}, order : {}", this.getClass().getSimpleName(), orderValue);
	}
}
