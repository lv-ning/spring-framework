package com.spring.introspect;

import com.spring.introspect.bean.IntrospectDemo;
import com.spring.introspect.bean.SpringBeanDemo;
import com.spring.introspect.config.IntrospectConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 内省测试
 *
 * @author nning_l@163.com
 * @since 2022-07-27
 */
public class IntrospectTest {

	@Test
	public void testIntrospect() throws Exception {
		// 获取 bean 信息
		BeanInfo beanInfo = Introspector.getBeanInfo(IntrospectDemo.class);
		// 属性名字和对应的描述符
		Map<String, PropertyDescriptor> propertyDescriptors = new HashMap<>();
		PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();// 属性描述符 get set 方法
		for (PropertyDescriptor pd : pds) {
			String name = pd.getName();
			propertyDescriptors.put(name, pd);
		}

		Method ageSetter = propertyDescriptors.get("age").getWriteMethod();
	}

	@Test
	public void testSpringInject() throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(IntrospectConfig.class);
		context.refresh();

		SpringBeanDemo beanDemo = context.getBean(SpringBeanDemo.class);
		beanDemo.printF();

		/**
		 * 1，属性上加 @Autowired 注解
		 *
		 * 通过 Java 反射实现
		 * field.set 方法
		 */

		/**
		 * 1，setter 方法上加 @Autowired 注解
		 *
		 * 如果注入模型是 1（byName），2（byType） 自动注入，那么 spring 会采用 Java 的自省机制发现 setter 方法调用执行
		 * 方法上的 @Autowired 注解失效
		 *
		 * 如果为 0（手动注入）那么和在属性上加注解差不多，底层查找所有加了 @Autowired 注解的方法，然后反射调用
		 * method.invoke
		 */

		/**
		 * 3，setter 方法，注入模型为 byType
		 * 如果注入模型是 1（byName），2（byType） 自动注入，那么 spring 会采用 Java 的自省机制发现 setter 方法调用执行
		 *
		 * 如果为 0（手动注入）那么和在属性上加注解差不多，底层查找所有加了 @Autowired 注解的方法，然后反射调用
		 */

		/**
		 * 4，通过 postProcessor 进行反射注入
		 * 通过实现 BeanFactoryPostProcessor 的 postProcessorBeanFactory 方法，对 bean 的
		 * BeanDefinition 属性进行设置
		 */
	}
}
