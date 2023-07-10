package com.spring.aop.service.impl;

import com.spring.aop.service.DeleteService;
import lombok.extern.slf4j.Slf4j;

/**
 * delete b
 *
 * @author nning_l@163.com
 * @since 2023-07-10
 */
@Slf4j
public class DeleteBServiceImpl implements DeleteService {

	@Override
	public void delete() {
		log.debug("-- delete b --");
	}
}
