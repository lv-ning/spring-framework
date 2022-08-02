package com.spring.transaction.controller;

import com.spring.transaction.service.ConfigurationService1;
import com.spring.transaction.service.ConfigurationService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * TODO
 *
 * @author nning_l@163.com
 * @since 2022-08-02
 */
@Component
public class ConfigurationController {

	@Autowired
	private PlatformTransactionManager platformTransactionManager;

	@Autowired
	ConfigurationService1 service1;

	@Autowired
	ConfigurationService2 service2;

	public void update() {
		System.out.println("xxx");
		DefaultTransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		transactionDefinition.setName("编程式事务");
		TransactionStatus transaction = platformTransactionManager.getTransaction(transactionDefinition);
		try {
			service1.update();
			service2.update();
			int i = 1/0;
			platformTransactionManager.commit(transaction);
		} catch (Exception e) {
			e.printStackTrace();
			platformTransactionManager.rollback(transaction);
		}
	}
}
