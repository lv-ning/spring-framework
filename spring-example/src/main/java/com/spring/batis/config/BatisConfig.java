package com.spring.batis.config;

import com.spring.batis.util.MyScan;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * mybatis 配置
 *
 * @author nning_l@163.com
 * @since 2022-03-12
 */
@ComponentScan(basePackages = "com.spring.batis")
//@MyScan(value = "com.spring.batis.mapper")// 自定义扫描来实现 mapper 的加载
@MapperScan(basePackages = "com.spring.batis.mapper")
//@ImportResource(value = "classpath:spring-batis.xml")
public class BatisConfig {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUsername("admin");
		dataSource.setPassword("admin");
		dataSource.setUrl("jdbc:mysql://101.35.56.113:33306/test?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC");
		return dataSource;
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
		return sqlSessionFactoryBean.getObject();
	}

//	/**
//	 * 注册一个映射器
//	 *
//	 * @return 自定义 mybatis 映射器
//	 */
//	@Bean
//	public MyFactoryBean<TMapper> mapperMyFactoryBeanT() {
//
//		return new MyFactoryBean<>(TMapper.class);
//	}
}
