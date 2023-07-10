package com.spring.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * aop
 *
 * @author nning_l@163.com
 * @since 2023-07-10
 */
@ComponentScan(value = "com.spring.aop")
@EnableAspectJAutoProxy
@Configuration
public class AopConfig {
}
