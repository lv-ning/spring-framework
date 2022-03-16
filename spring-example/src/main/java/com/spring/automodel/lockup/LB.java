package com.spring.automodel.lockup;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author nning_l@163.com
 * @since 2022-03-07
 */
@Slf4j
@Component
public class LB {

	@Autowired
	private LA la;

	public void test() {
		log.debug("la info : {}", la);
		log.debug("la info : {}", la);
	}
}
