package com.chris.jackson;

import com.chris.bean.JacksonBean;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonDemo {
	public static String toJson(Object object) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		JacksonBean jacksonBean = new JacksonBean();
		jacksonBean.setName("chris");
		jacksonBean.setAge(26);

		String json = toJson(jacksonBean);
		System.out.println(json); // result {"name":"chris","age":26}
	}
}
