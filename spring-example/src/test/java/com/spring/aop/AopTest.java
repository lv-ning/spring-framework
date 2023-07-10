package com.spring.aop;

import com.spring.aop.config.AopConfig;
import com.spring.aop.davice.AfterAround;
import com.spring.aop.davice.AudienceAround;
import com.spring.aop.service.DeleteService;
import com.spring.aop.service.IService;
import com.spring.aop.service.UserService;
import com.spring.aop.service.impl.AService;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * aop 测试
 *
 * @author nning_l@163.com
 * @since 2022-07-06
 */
public class AopTest {

	@Test
	public void testCustomAop() {
		// 不借助 spring 容器实现
		ProxyFactory pf = new ProxyFactory();

		pf.addInterface(IService.class);// 设置接口，使用 jdk 动态代理
		pf.addAdvice(new AudienceAround());// 设置通知
		pf.addAdvice(new AfterAround());// 设置通知
		pf.setTarget(new AService());// 目标对象

		IService service = (IService) pf.getProxy();
		service.m();
	}

	@Test
	public void aopIntroductions() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AopConfig.class);
		context.refresh();

		UserService bean = context.getBean(UserService.class);
		bean.query();
		bean.update();

		// 不需要再这样手动调用了
//		DeleteService deleteService = (DeleteService) context.getBean("userService");
//		deleteService.delete();
	}
}
