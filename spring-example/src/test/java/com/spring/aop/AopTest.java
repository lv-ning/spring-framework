package com.spring.aop;

import com.spring.aop.davice.AfterAround;
import com.spring.aop.davice.AudienceAround;
import com.spring.aop.service.IService;
import com.spring.aop.service.impl.AService;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;

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
}
