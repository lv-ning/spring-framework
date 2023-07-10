package com.spring.aop.service.impl;

import com.spring.aop.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 用户
 *
 * @author nning_l@163.com
 * @since 2023-07-10
 */
@Slf4j
@Component
public class UserServiceImpl implements UserService {

	@Override
	public void query() {
		log.debug("-- query --");
	}

	@Override
	public void update() {
		log.debug("-- update --");
	}
}
