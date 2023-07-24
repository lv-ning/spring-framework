package com.spring.lifecycle.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author nning_l@163.com
 * @since 2023-07-24
 */
@Component
@Slf4j
public class E implements D {

	@Autowired
	private C c;

	@Override
	public void m0() {
		log.debug("m0");
	}
}
