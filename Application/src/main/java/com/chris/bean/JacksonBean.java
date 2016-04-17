package com.chris.bean;

import java.io.Serializable;

public class JacksonBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private Integer age;

	public JacksonBean() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "JacksonBean [name=" + name + ", age=" + age + "]";
	}

}
