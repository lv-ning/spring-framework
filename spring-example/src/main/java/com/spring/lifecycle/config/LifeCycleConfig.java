package com.spring.lifecycle.config;

import com.spring.lifecycle.util.EnableAspectAop;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 生命周期
 *
 * @author nning_l@163.com
 * @since 2022-03-27
 */
@EnableAspectAop
@EnableAspectJAutoProxy
@ComponentScan("com.spring.lifecycle")
public class LifeCycleConfig {
}
