package com.spring.lifecycle.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 生命周期
 *
 * @author nning_l@163.com
 * @since 2022-03-27
 */
@EnableAspectJAutoProxy
@ComponentScan("com.spring.lifecycle")
public class LifeCycleConfig {
}
