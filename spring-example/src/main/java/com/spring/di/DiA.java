package com.spring.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * a
 *
 * @author nning_l@163.com
 * @since 2022-02-21
 */
@Component(value = "a")
public class DiA {

	public DiA() {
		System.out.println("无参构造器");
	}

	public DiA(DiB b) {
		System.out.println("有参构造器 b");
	}

	@Autowired
	private DiB b;
}
