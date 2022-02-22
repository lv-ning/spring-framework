package com.spring.constructor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 内部类实现 bean 注入
 *
 * 实例化一个内部类就是实例化一个实例属性
 * 可以查看 AbstractAutowireCapableBeanFactory 的 determineConstructorsFromBeanPostProcessors 方法
 *
 * @author nning_l@163.com
 * @since 2022-02-19
 */
public class H {

	// h.C
	class C {
	}

	// static 静态修饰后就不是一个实例属性了
//	static class C {
//	}

	// 为 C 添加一个构造方法也可以的，不过构造方法中必须有已经注入的 bean
	// context.register(H.class);
//	class C {
//		public C(H h) {
//		}
//	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//		context.register(H.class);
		context.register(C.class);
		context.refresh();
		System.out.println(context.getBean(C.class));
	}
}
