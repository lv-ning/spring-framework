package com.spring.batis;

import com.spring.batis.config.BatisConfig;
import com.spring.batis.mapper.TMapper;
import com.spring.batis.mybatis.MySqlSession;
import com.spring.batis.service.TService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author nning_l@163.com
 * @since 2022-03-12
 */
@Slf4j
public class BatisTest {

	@Test
	public void defaultBatis() {
		AnnotationConfigApplicationContext
				context = new AnnotationConfigApplicationContext(BatisConfig.class);

		TService service = context.getBean(TService.class);
		Map<String, Object> resultMap = service.findById(1);

		List<Map<String, Object>> resultList = service.findAll();
		log.debug("resultMap:{}", resultMap);
		log.debug("----------------------------------------------");
		log.debug("resultList:{}", resultList);
	}

	@Test
	public void onlyBatis() {
		BatisConfig config = new BatisConfig();

		// 获取数据源
		DataSource dataSource = config.dataSource();
		TransactionFactory transactionFactory =
				new JdbcTransactionFactory();
		Environment development =
				new Environment("development", transactionFactory, dataSource);
		Configuration configuration = new Configuration(development);

		configuration.addMapper(TMapper.class);

		SqlSessionFactory sqlSessionFactory =
				new SqlSessionFactoryBuilder().build(configuration);
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 动态代理
		TMapper mapper = sqlSession.getMapper(TMapper.class);
		Map<String, Object> resultMap = mapper.findById(1);
		log.debug("resultMap:{}", resultMap);
	}

	@Test
	public void customBatis() {
		TMapper mapper = MySqlSession.getMapper(TMapper.class);
		mapper.findById(1);
		mapper.findAll();
	}

	/**
	 * 将对象放入容器中的方法
	 * 1：注解：@Bean
	 * 2：factoryBean 接口实现
	 * 3：spring api
	 */
	@Test
	public void customObjectBatis() {
		AnnotationConfigApplicationContext
				context = new AnnotationConfigApplicationContext(BatisConfig.class);

		TService service = context.getBean(TService.class);
		service.findAll();
	}

	@Test
	public void customObjectBatisApi() {
		AnnotationConfigApplicationContext
				context = new AnnotationConfigApplicationContext();

		// 使用 spring api 进行注册单例 bean
		context.register(BatisConfig.class);
		TMapper mapper = MySqlSession.getMapper(TMapper.class);
		context.getBeanFactory().registerSingleton("mapper", mapper);
		context.refresh();

		TService service = context.getBean(TService.class);
		service.findAll();
	}

	@Test
	public void customObjectMyBatisApi() {
		AnnotationConfigApplicationContext
				context = new AnnotationConfigApplicationContext(BatisConfig.class);

		TService service = context.getBean(TService.class);
		service.findAll();
	}

	@Test
	public void beanFactoryPostProcessorTest() {
		AnnotationConfigApplicationContext
				context = new AnnotationConfigApplicationContext();
		context.scan("com.spring.batis.bean");
		context.refresh();
	}

}
