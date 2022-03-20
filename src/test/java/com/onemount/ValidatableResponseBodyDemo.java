package com.onemount;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class ValidatableResponseBodyDemo {
	
	public static final String BASE_URL = "https://api.github.com/";
	
	@Test
	public void matcherExemple() {
		/*
		RestAssured.get(BASE_URL)
			.then()
			.body("url", ResponseAwareMatcher<Response> -> Matcher.con)
			*/
	}
	
	@Test
	public void rootPathExemple() {
		
		RestAssured.get(BASE_URL + "rate_limit")
			.then()
			.rootPath("resources.core")
				.body("limit", equalTo(60))
				.body("remaining", equalTo(55))
			.rootPath("resources.search")
				.body("limit", equalTo(60))
				.body("remaining", equalTo(55))
			.noRootPath()
				.body("resources.graphql.limit", is(0));
		
	}

}
