package com.onemount;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DemoHamcresrMatchers {
	
public static final String BASE_URL = "https://api.github.com";
	
	@Test
	public void demoHamcresrMatchers() {
		RestAssured.get(BASE_URL)
			.then()
			.header("X-RateLimit-Limit", Integer::parseInt, Matchers.equalTo(60))
			;
		
	}

}
