package com.onemount;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Type;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.onemount.module.AnotherUser;
import com.onemount.module.User;

import io.restassured.RestAssured;
import io.restassured.internal.mapping.Jackson2Mapper;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.path.json.mapper.factory.Jackson2ObjectMapperFactory;

public class ObjectMappingDemo {
	
	public static final String BASE_URL = "https://api.github.com/users/rest-assured";
	
	@Test
	@Ignore
	public void objectMappingTestOne() {
	User user =	RestAssured.get(BASE_URL)// dùng và lưu nó dưới biến người dùng
			.as(User.class);  //quản lý phản hồi json dưới dạng lớp người
	
	assertEquals(user.getLogin(), "rest-assured");
	assertEquals(user.getId(), 19369327);
	assertEquals(user.getPublicRepos(), 2);
	}
	
	@Test
	@Ignore
	public void objectMappingReplyingTestOne() {
	User user =	RestAssured.get(BASE_URL)
			.as(User.class, ObjectMapperType.JACKSON_2);  //as có thể quá tải
	
	assertEquals(user.getLogin(), "rest-assured");
	}
	
	@Test
	public void objectMappingUsingSpecifiedMapper() {
		//com.fasterxml.jackson.databind.ObjectMapper om = new com.fasterxml.jackson.databind.ObjectMapper(); sử dụng ojectmapper của rest assure
		
		ObjectMapper mapper = new Jackson2Mapper(new Jackson2ObjectMapperFactory() {
			
			@Override
			public com.fasterxml.jackson.databind.ObjectMapper create(Type cls, String charset) {
				com.fasterxml.jackson.databind.ObjectMapper om = new com.fasterxml.jackson.databind.ObjectMapper();
				om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				return om;
			}
		});
		
		AnotherUser user =	RestAssured.get(BASE_URL)
				.as(AnotherUser.class, mapper);  
		assertEquals(user.getLogin(), "rest-assured");
	}

}
