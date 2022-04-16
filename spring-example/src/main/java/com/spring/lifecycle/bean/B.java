package com.spring.lifecycle.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author nning_l@163.com
 * @since 2022-03-27
 */
@Component
@Slf4j
public class B {

	public B() {

	}

	public void mB() {

		log.debug("b mB");
	}
}
