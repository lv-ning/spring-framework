package com.spring.automodel.introspector;

import lombok.Data;

/**
 * 实体类
 *
 * @author nning_l@163.com
 * @since 2022-02-21
 */
@Data
public class UserInfo {

	private long id;
	private String username;
	private int age;
	private String address;
}
