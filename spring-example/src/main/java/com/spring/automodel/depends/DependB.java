package com.spring.automodel.depends;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author nning_l@163.com
 * @since 2022-03-07
 */
@Slf4j
@Component(value = "db")
public class DependB {
	public DependB() {

		log.debug("b 构造方法");
	}
}
