package com.spring.ethancer.bean;

import lombok.extern.slf4j.Slf4j;

/**
 * TODO
 *
 * @author nning_l@163.com
 * @since 2022-04-19
 */
@Slf4j
public class A {
	public A() {
		log.debug("A init");
	}

	public void m0() {
		log.debug("------ ====== m0");
	}

	public void m1() {
		log.debug("------ ====== m1");
	}

	public void m2() {
		log.debug("------ ====== m2");
	}
}
