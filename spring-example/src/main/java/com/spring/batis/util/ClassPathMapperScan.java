package com.spring.batis.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.util.Set;

/**
 * 自定义扫描
 *
 * @author nning_l@163.com
 * @since 2022-04-15
 */
@Slf4j
public class ClassPathMapperScan extends ClassPathBeanDefinitionScanner {

	private final BeanDefinitionRegistry registry;

	public ClassPathMapperScan(BeanDefinitionRegistry registry) {
		super(registry);
		this.registry = registry;
	}

	@Override
	protected void registerDefaultFilters() {
//		super.registerDefaultFilters();
		// 只添加一个注解
		addIncludeFilter(new AnnotationTypeFilter(Mapper.class));
	}

	@Override
	protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
		// 必须是接口
		return beanDefinition.getMetadata().isInterface();
	}

	@Override
	public Set<BeanDefinitionHolder> doScan(String... basePackages) {
		Set<BeanDefinitionHolder> scan = super.doScan(basePackages);

		AbstractBeanDefinition beanDefinition;
		for (BeanDefinitionHolder holder : scan) {
			String beanName = holder.getBeanName();
			beanDefinition = (AbstractBeanDefinition) holder.getBeanDefinition();
			String beanClassName = beanDefinition.getBeanClassName();
			beanDefinition.setBeanClass(MyFactoryBean.class);
			beanDefinition.getPropertyValues().add("mapperInterface", beanClassName);

			registry.registerBeanDefinition(beanName, beanDefinition);
		}
		return scan;
	}
}
