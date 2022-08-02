package com.spring.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * TODO
 *
 * @author nning_l@163.com
 * @since 2022-08-01
 */
@Component
public class PlatformTransactionManagerTService {

	/**
	 * 这个对象需要配置
	 * 默认不存在 spring 容器当中
	 */
	@Autowired
	private PlatformTransactionManager platformTransactionManager;

	@Autowired
	private JdbcTemplate jdbcTemplate;

//	@Transactional
	public void update() {
		// 获取事务定义
		/**
		 * 定义：
		 * 1，名字
		 * 2，隔离级别
		 * 3，传播属性
		 * 4，是否只读
		 * 5，超时
		 */
		DefaultTransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		transactionDefinition.setName("事务名字");
		// 获取事务状态
		TransactionStatus transaction = platformTransactionManager.getTransaction(transactionDefinition);
		try {
			jdbcTemplate.update("update t set `desc`=? where `name`=?", "zhangsan", "张三");
//			int i = 1/0;
			jdbcTemplate.update("update t set `desc`=? where `name`=?", "lisi", "李四");
			platformTransactionManager.commit(transaction);
		} catch (Exception e) {
			e.printStackTrace();
			platformTransactionManager.rollback(transaction);
		}
	}
}
