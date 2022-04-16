package com.spring.batis.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

/**
 * 使用{@link ImportBeanDefinitionRegistrar} 动态注入多个 bean
 *
 * @author nning_l@163.com
 * @since 2022-03-16
 */
@Slf4j
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		Map<String, Object> map = importingClassMetadata.getAnnotationAttributes(MyScan.class.getName());
		String packageName = (String) map.get("value");
		log.info("packageName : {}", packageName);

		BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(MapperRegistryPostProcessor.class);
		builder.addPropertyValue("packageName", packageName);
		AbstractBeanDefinition beanDefinition = builder.getBeanDefinition();
		registry.registerBeanDefinition("mapperRegistryPostProcessor", beanDefinition);
//		// 模拟扫描到的 所有 mapper
//		Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();
//		BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(TMapper.class);
//		beanDefinitionMap.put("tmapper", builder.getBeanDefinition());
//		builder = BeanDefinitionBuilder.genericBeanDefinition(AMapper.class);
//		beanDefinitionMap.put("amapper", builder.getBeanDefinition());
//
//		// 使用 BeanDefinition 将 FactoryBean 注入到容器中，
//		// FactoryBean 的 getObject 方法会返回真正的代理 bean
//		// 所以注入属性的时候设置指定的属性即可
//		for (Map.Entry<String, BeanDefinition> entry : beanDefinitionMap.entrySet()) {
//			String key = entry.getKey();
//			AbstractBeanDefinition beanDefinition = (AbstractBeanDefinition) entry.getValue();
//			Class<?> beanClass = beanDefinition.getBeanClass();
//			log.debug("before:{}", beanDefinition.getBeanClass().getName());
//			beanDefinition.setBeanClass(MyFactoryBean.class);
//			log.debug("after:{}", beanDefinition.getBeanClass().getName());
//			beanDefinition.getPropertyValues().add("mapperInterface", beanClass.getName());
//
//			registry.registerBeanDefinition(key, beanDefinition);
//		}
	}
}
