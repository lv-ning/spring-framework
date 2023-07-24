package com.spring.lifecycle.util;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * TODO
 *
 * @author nning_l@163.com
 * @since 2023-07-24
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(JDKProxyBeanPostProcessor.class)
public @interface EnableAspectAop {
}
