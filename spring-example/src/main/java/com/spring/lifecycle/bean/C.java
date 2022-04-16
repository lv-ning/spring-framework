package com.spring.lifecycle.bean;

import org.springframework.stereotype.Component;

import javax.annotation.ManagedBean;
import javax.inject.Named;

/**
 * @see Named
 * @see ManagedBean
 * @see Component
 * 三个注解功能一样
 *
 * @author nning_l@163.com
 * @since 2022-03-27
 */
//@Named
//@ManagedBean
@Component
public class C {
}
