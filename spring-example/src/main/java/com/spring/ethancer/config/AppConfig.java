package com.spring.ethancer.config;

import com.spring.ethancer.bean.X;
import com.spring.ethancer.bean.Y;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Configuration 与 Component 的区别就是：
 * Configuration 会生成一个 cglib 代理类
 * 使得 当前类里面的所有类只会创建一次 保障 bean 的作用域
 * Component 会因为创建的多少而创建多少
 * 如下：
 * Configuration 创建 x 只有一次
 * Component 创建了两次 x
 *
 * @author nning_l@163.com
 * @since 2022-04-18
 */
@Slf4j
@ComponentScan(value = "com.spring.ethancer.bean")
@Configuration
//@Component
public class AppConfig {

	@Bean
	public X x() {
		log.info("x create");
		return new X();
	}

	@Bean
	public Y y() {
		x();
		return new Y();
	}
}
