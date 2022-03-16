package com.spring.automodel.introspector;

import java.beans.BeanDescriptor;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * Java 内省
 *
 * @author nning_l@163.com
 * @since 2022-02-21
 */
public class BeanDescriptors {
	public static void main(String[] args) throws Exception {
		UserInfo userInfo = new UserInfo();

		// 第一种方式
		BeanInfo beanInfo = Introspector.getBeanInfo(userInfo.getClass());
		BeanDescriptor beanDescriptor = beanInfo.getBeanDescriptor();
		System.out.println("beanDescriptor : " + beanDescriptor);
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
			System.out.println(propertyDescriptor);
			Method writeMethod = propertyDescriptor.getWriteMethod();
			if ("username".equals(propertyDescriptor.getName())) {
				writeMethod.invoke(userInfo, "张三");
			}
			Method readMethod = propertyDescriptor.getReadMethod();
			System.out.println("invoke : " + readMethod.invoke(userInfo));
		}
		System.out.println("11111111 " + userInfo);

		// 第二种方式
		PropertyDescriptor propertyDescriptor = new PropertyDescriptor("id", UserInfo.class);
		Method writeMethod = propertyDescriptor.getWriteMethod();
		writeMethod.invoke(userInfo, 1);
		System.out.println("22222222 " + userInfo);
	}
}
