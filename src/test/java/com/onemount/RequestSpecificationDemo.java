package com.onemount;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationDemo {
	
	public static final String BASE_URL = "https://api.github.com/";
	
	@Test
	public void testUsingLocalRequestSpec() {
		RestAssured
			.given()
				.spec(getDefauldRequestSpec())
			.when()
				.get()
			.then()
				.statusCode(200);
	}
	
	public static RequestSpecification getDefauldRequestSpec() {
		return new RequestSpecBuilder()
				.setBaseUri(BASE_URL)
				.setConfig(ConfigFactory.getDefaultConfig())
				.build();
		
	}

}
