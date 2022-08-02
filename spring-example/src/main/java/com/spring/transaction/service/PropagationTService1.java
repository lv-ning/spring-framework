package com.spring.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 * 事务传播特性
 *
 * Error 或 RuntimeException 会回滚
 * Check 异常不会回滚如：IOException
 *
 * @author nning_l@163.com
 * @since 2022-08-02
 */
@Component
public class PropagationTService1 {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private PropagationTService2 propagationTService2;

	@Transactional(propagation = Propagation.REQUIRED)
	public void update() {
		jdbcTemplate.update("update t set `desc`=? where `name`=?", "zhangsan", "张三");
		propagationTService2.update();
//		int i = 1/0;
//		throw new NullPointerException();
//		throw new IOException();
	}
}
