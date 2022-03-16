package com.spring.automodel.lockup;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author nning_l@163.com
 * @since 2022-03-07
 */
@Slf4j
@Component
public abstract class LC {
	@Lookup
	public abstract LA create();

	public void test() {
		LA la = create();
		log.debug("la info : {}", la);
		la = create();
		log.debug("la info : {}", la);
	}
}
