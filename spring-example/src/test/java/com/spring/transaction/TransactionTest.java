package com.spring.transaction;

import com.spring.transaction.config.AnnoAndXmlTransactionConfig;
import com.spring.transaction.config.TransactionConfig;
import com.spring.transaction.controller.ConfigurationController;
import com.spring.transaction.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * 事务测试
 *
 * @author nning_l@163.com
 * @since 2022-08-01
 */
public class TransactionTest {

	/**
	 * 编程式事务
	 */
	@Test
	public void testPlatformTransactionManagerTService() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(TransactionConfig.class);
		context.refresh();

		PlatformTransactionManagerTService service = context.getBean(PlatformTransactionManagerTService.class);
		service.update();
	}

	/**
	 * 事务模板
	 */
	@Test
	public void testTransactionTemplates() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(TransactionConfig.class);
		context.refresh();

		TransactionTemplateTService service = context.getBean(TransactionTemplateTService.class);
		service.update();
	}

	/**
	 * 加了 @Configuration 和 不加 @Configuration 注解的事务
	 */
	@Test
	public void testConfiguration() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(TransactionConfig.class);
		context.refresh();

		ConfigurationController bean = context.getBean(ConfigurationController.class);
		bean.update();
	}

	/**
	 * xml 形式的
	 */
	@Test
	public void testXmlTx() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:appTransaction4Xml.xml");
		XMLTService service = context.getBean(XMLTService.class);
		service.update();
	}

	@Test
	public void testAnno() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(TransactionConfig.class);
		context.refresh();

		AnnoTService bean = context.getBean(AnnoTService.class);
		bean.update();
	}

	/**
	 * 注解 + xml
	 */
	@Test
	public void testAnnoAndXml() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnoAndXmlTransactionConfig.class);

		AnnoAndXmlTService bean = context.getBean(AnnoAndXmlTService.class);
		bean.update();
	}

	/**
	 * 传播属性
	 * 如果异常被处理，则不会回滚
	 * 检查异常不会回滚
	 */
	@Test
	public void testPropagationRequired() throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TransactionConfig.class);

//		PropagationController bean = context.getBean(PropagationController.class);
//		bean.update();

		PropagationTService1 bean = context.getBean(PropagationTService1.class);
		bean.update();
	}

	/**
	 * REQUIRES_NEW tx1 update t set field0 where field
	 * 如果 where 的 field 不是一个索引字段，会进行表锁
	 * 如果 where 的field 加了索引，则是行锁
	 */
	@Test
	public void testPropagationRequiredNew() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TransactionConfig.class);

		PropagationTService1 bean = context.getBean(PropagationTService1.class);
		bean.update();
	}

	/**
	 * 嵌套事务
	 * 如果有事务，则会 create nested transaction 创建嵌套事务
	 */
	@Test
	public void testPropagationNested() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TransactionConfig.class);

		PropagationTService1 bean = context.getBean(PropagationTService1.class);
		bean.update();
	}

	/**
	 * 强制事务
	 * 如果存在事务，则加入，如果没有事务则异
	 * 没有事务则出现异常
	 */
	@Test
	public void testPropagationMandatory() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TransactionConfig.class);

		PropagationTService1 bean = context.getBean(PropagationTService1.class);
		bean.update();
	}

	/**
	 * 没有事务，不加入，非事务运行
	 * 有事务，就事务运行
	 */
	@Test
	public void testPropagationSupports() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TransactionConfig.class);

		PropagationTService1 bean = context.getBean(PropagationTService1.class);
		bean.update();
	}

	/**
	 * 从来不用事务，如果有事务，则异常
	 */
	@Test
	public void testPropagationNever() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TransactionConfig.class);

		PropagationTService1 bean = context.getBean(PropagationTService1.class);
		bean.update();
	}
}
