package com.spring.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 注解事务
 *
 * @author nning_l@163.com
 * @since 2022-08-02
 */
@Component
public class AnnoAndXmlTService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional
	public void update() {
		jdbcTemplate.update("update t set `desc`=? where `name`=?", "zhangsan", "张三");
			int i = 1/0;
		jdbcTemplate.update("update t set `desc`=? where `name`=?", "lisi", "李四");
	}

}
