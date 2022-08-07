package com.spring.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 事务传播特性
 *
 * 默认回滚规则是 RuntimeException 或者 Error
 *
 * @author nning_l@163.com
 * @since 2022-08-02
 */
@Component
public class PropagationTService2 {

	@Autowired
	private JdbcTemplate jdbcTemplate;

//	@Transactional(propagation = Propagation.REQUIRED)
//	@Transactional(propagation = Propagation.REQUIRES_NEW)// 如果有则挂起，没有创建新的
//	@Transactional(propagation = Propagation.NESTED)// 如果有则挂起，没有创建新的
//	@Transactional(propagation = Propagation.MANDATORY)// 如果存在事务，则加入，如果没有事务则异常
//	@Transactional(propagation = Propagation.SUPPORTS)// 存在事务，则加入事务，如果没有事务，则以非事务进行运行
//	@Transactional(propagation = Propagation.NOT_SUPPORTED)// 以非事务方式运行，如果存在事务，则挂起来
	@Transactional(propagation = Propagation.NEVER)// 从来不用事务，如果有事务，则异常
	public void update() {
		jdbcTemplate.update("update t set `desc`=? where `name`=?", "lisi", "李四");
//		throw new NullPointerException();
//		try {
//			int i = 1/0;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
}
