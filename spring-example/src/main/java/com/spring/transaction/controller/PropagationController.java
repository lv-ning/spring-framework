package com.spring.transaction.controller;

import com.spring.transaction.service.PropagationTService1;
import com.spring.transaction.service.PropagationTService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author nning_l@163.com
 * @since 2022-08-02
 */
@Component
public class PropagationController {

	@Autowired
	private PropagationTService1 propagationTService1;

	@Autowired
	private PropagationTService2 propagationTService2;

	public void update() {
		try {
			propagationTService1.update();
//			propagationTService2.update();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
