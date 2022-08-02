package com.spring.transaction.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

/**
 * TODO
 *
 * @author nning_l@163.com
 * @since 2022-08-01
 */
@EnableTransactionManagement// 开启声明事务注解
@ComponentScan(value = "com.spring.transaction")
@Configuration
public class TransactionConfig {

	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUsername("admin");
		dataSource.setPassword("admin");
		dataSource.setUrl("jdbc:mysql://101.35.56.113:33306/test?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC");
		return dataSource;
	}

	/**
	 * 事务管理器
	 */
	@Bean
	public PlatformTransactionManager platformTransactionManager() {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource());
		return transactionManager;
	}

	/**
	 * 事务模板
	 */
	@Bean
	public TransactionTemplate transactionTemplate() {
		TransactionTemplate transactionTemplate = new TransactionTemplate();
		transactionTemplate.setTransactionManager(platformTransactionManager());
		return transactionTemplate;
	}
}
