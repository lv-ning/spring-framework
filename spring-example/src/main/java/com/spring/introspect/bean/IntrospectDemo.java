package com.spring.introspect.bean;

/**
 * TODO
 *
 * @author nning_l@163.com
 * @since 2022-07-27
 */
public class IntrospectDemo {

	private Integer age;
	private String name;

	// no set get
	private String email;

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {

	}

	public String getPassword() {
		return "pass";
	}
}
