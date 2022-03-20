package com.onemount;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class HeadAndOptionsDemo {
	
	public static final String BASE_URL = "https://api.github.com/";
	@Test
	public void headTest() {
		
		RestAssured.head(BASE_URL)
			.then()
			.statusCode(200)
			.body(Matchers.emptyOrNullString());
	}
	
	@Test
	public void optionsTest() {
		
		RestAssured.options(BASE_URL)
			.then()
			.statusCode(204) // no content
			.header("access-control-allow-methods", Matchers.equalTo("GET, POST, PATCH, PUT, DELETE"))
			.body(Matchers.emptyOrNullString());
	}

}
