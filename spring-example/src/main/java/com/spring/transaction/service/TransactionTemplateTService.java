package com.spring.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * 事务模板
 *
 * @author nning_l@163.com
 * @since 2022-08-01
 */
//@Component
public class TransactionTemplateTService {

	@Autowired
	private TransactionTemplate transactionTemplate;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	//	@Transactional
	public void update() {
		Object execute = transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				try {
					// 获取事务定义
					jdbcTemplate.update("update t set `desc`=? where `name`=?", "zhangsan", "张三");
					// int i = 1 / 0;
					jdbcTemplate.update("update t set `desc`=? where `name`=?", "lisi", "李四");
				} catch (Exception e) {
					e.printStackTrace();
					status.setRollbackOnly();
				}
			}
		});

	}
}
