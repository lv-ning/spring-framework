package com.spring.transaction.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
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
//@Configuration
@ImportResource(value = {"classpath:appTransaction4XmlAndAnno.xml"})
public class AnnoAndXmlTransactionConfig {

}
