package com.spring.transaction.service;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * TODO
 *
 * @author nning_l@163.com
 * @since 2022-08-02
 */
public class XMLTService {

	private JdbcTemplate jdbcTemplate;

	public void update() {
		jdbcTemplate.update("update t set `desc`=? where `name`=?", "zhangsan", "张三");
			int i = 1/0;
		jdbcTemplate.update("update t set `desc`=? where `name`=?", "lisi", "李四");
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
