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
@Component(value = "z3")
@Order(value = 6)
public class Z3 {
	public Z3() {

		log.debug("order : {}", this.getClass().getAnnotation(Order.class).value());
	}

	// spring 自己调用
	@PostConstruct
	public void initMethod() {

		log.debug("bean init z3");
	}
}
