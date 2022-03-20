package com.onemount;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.text.IsEmptyString;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;

public class ValidatableResponseDemo {
	
	public static final String BASE_URL = "https://api.github.com";
	
	@Test
	public void basicValidatableExemple() {
		RestAssured.get(BASE_URL)
			.then()
			.assertThat()
				.statusCode(200)
				.statusCode(Matchers.lessThan(300))
			.and()
				.contentType(ContentType.JSON)
			.and().assertThat()
				.header("X-RateLimit-Limit", "60")
				.header("X-RateLimit-Limit", Matchers.containsStringIgnoringCase("60"))
				.time(Matchers.lessThan(2L), TimeUnit.SECONDS)
				.header("etag", Matchers.notNullValue());
			
		
	}
	

}
