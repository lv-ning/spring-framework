package com.spring.automodel.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * TODO
 *
 * @author nning_l@163.com
 * @since 2022-03-06
 */
@Slf4j
@Component(value = "z1")
@Order(value = 5)
public class Z1 {
	public Z1() {

		log.debug("order : {}", this.getClass().getAnnotation(Order.class).value());
	}

	// spring 自己调用
	@PostConstruct
	public void initMethod() {

		log.debug("bean init z1");
	}
}
