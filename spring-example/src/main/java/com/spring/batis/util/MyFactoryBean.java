package com.spring.batis.util;

import com.spring.batis.mapper.TMapper;
import com.spring.batis.mybatis.MySqlSession;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * 工作前提，自己必须生效（存在于 spring 容器中）
 * #mapperInterface 必须有值
 *
 * @author nning_l@163.com
 * @since 2022-03-13
 */
//@Component
public class MyFactoryBean<T> implements FactoryBean<T> {

	private Class<T> mapperInterface;

	public MyFactoryBean() {

	}

	public MyFactoryBean(Class<T> mapperInterface) {
		this.mapperInterface = mapperInterface;
	}

	@Override
	public T getObject() throws Exception {
		return MySqlSession.getMapper(mapperInterface);
	}

	@Override
	public Class<T> getObjectType() {
		return mapperInterface;
	}

	/**
	 * 是否单例，默认单例
	 *
	 * @return 单例
	 */
	@Override
	public boolean isSingleton() {
		return true;
	}

	public Class<T> getMapperInterface() {
		return mapperInterface;
	}

	public void setMapperInterface(Class<T> mapperInterface) {
		this.mapperInterface = mapperInterface;
	}
}
