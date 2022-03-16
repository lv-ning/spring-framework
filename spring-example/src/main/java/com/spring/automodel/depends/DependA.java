package com.spring.automodel.depends;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author nning_l@163.com
 * @since 2022-03-07
 */
@Slf4j
@Component
@DependsOn(value = "db")
public class DependA {

	public DependA() {

		log.debug("a 构造方法");
	}
}
