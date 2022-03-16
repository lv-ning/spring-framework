package com.spring.automodel.init;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试
 *
 * @author nning_l@163.com
 * @since 2022-02-19
 */
public class Test {
	public static void main(String[] args) {
		// spring 容器
		AnnotationConfigApplicationContext
				context = new AnnotationConfigApplicationContext();
		context.register(Bean.class);// 扫描到 spring 容器当中
		context.refresh();// 容器初始化 （spring 容器实例化和初始化是有区别的）
		System.out.println(context.getBean(Bean.class));
	}
}
