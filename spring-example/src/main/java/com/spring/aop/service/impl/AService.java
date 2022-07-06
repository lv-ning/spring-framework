package com.spring.aop.service.impl;

import com.spring.aop.service.IService;
import lombok.extern.slf4j.Slf4j;

/**
 * TODO
 *
 * @author nning_l@163.com
 * @since 2022-07-06
 */
@Slf4j
public class AService implements IService {

	@Override
	public void m() {
		log.debug("a service m method");
	}
}
