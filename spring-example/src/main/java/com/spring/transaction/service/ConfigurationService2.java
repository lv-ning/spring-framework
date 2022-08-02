package com.spring.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author nning_l@163.com
 * @since 2022-08-02
 */
@Component
public class ConfigurationService2 {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void update() {
		jdbcTemplate.update("update t set `desc`=? where `name`=?", "lisi", "李四");
	}
}
