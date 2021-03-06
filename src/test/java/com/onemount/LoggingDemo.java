package com.onemount;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;

public class LoggingDemo {
	
	public static final String BASE_URL = "https://jsonplaceholder.typicode.com/posts";
	
	@Test
	public void test() {
		
		RestAssured
			.given()
				.log().all()
				//or
				.log().headers()
				.log().body()
			.when()
				.get(BASE_URL)
			.then()
				//no condition
				.log().headers()
				.log().status()
				//with condition
				.log().ifValidationFails(LogDetail.HEADERS)
				.statusCode(HttpStatus.SC_OK);
		
	}

}
