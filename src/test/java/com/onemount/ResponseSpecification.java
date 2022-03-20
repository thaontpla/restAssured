package com.onemount;

import org.codehaus.groovy.control.HasCleanup;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;

public class ResponseSpecification {
	
	public static final String BASE_URL = "https://api.github.com/";
	
	/*
	@BeforeClass
	public void setup() {
		RestAssured.responseSpecification = new ResponseSpecBuilder()
								.expectStatusCode(404)
								.expectContentType(ContentType.JSON)
								.build();
	}
	
	@AfterClass
	public void cleanup() {//không muốn thông số kĩ thuật áp dụng nữa sau khi một nhóm ktra đã chạy
		RestAssured.responseSpecification = null;
	}*/
	
	ResponseSpecification commomResponseSpect = (ResponseSpecification) new ResponseSpecBuilder()
			.expectStatusCode(404)
			.expectContentType(ContentType.JSON)
			.build();
	
	@Test
	public void testOne() {
		RestAssured.get(BASE_URL + "non/existing/url")
				.then()
					.spec((io.restassured.specification.ResponseSpecification) commomResponseSpect);
	}
	
	@Test
	public void testTow() {
		RestAssured.get(BASE_URL + "non/existing/url")
		.then()
			.spec((io.restassured.specification.ResponseSpecification) commomResponseSpect);
	}
}
