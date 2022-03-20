package com.onemount;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.FailureConfig;
import io.restassured.config.RedirectConfig;
import io.restassured.listener.ResponseValidationFailureListener;

public class ConfigDemo {
	
	public static final String BASE_URL = "https://api.github.com/";
	
	@BeforeSuite
	void setup() {
		RestAssured.config = ConfigFactory.getDefaultConfig();
	}
	
	@Test
	@Ignore
	public void redirectsTest() {
		RestAssured.config = RestAssured.config()
				.redirect(RedirectConfig.redirectConfig().followRedirects(true).maxRedirects(0));
		
		RestAssured.get(BASE_URL +"repos/twitter/bootstrap")
			.then()
			.statusCode(200);
	}
	@Test
	public void failureExemple() {
		ResponseValidationFailureListener failureListener = (reqSpec, resSpec, response) ->
				System.out.printf("We have a failure, " + "response status wass %s and the body contains: %s", response.getStatusCode(), response.getBody().asPrettyString());
				
		RestAssured.config = RestAssured.config()
				.failureConfig(FailureConfig.failureConfig().failureListeners(failureListener));
		
		RestAssured.get(BASE_URL + "userss/andrejs-ps")
			.then()
			.body("some.path", Matchers.equalTo("a thing"));
	}

}
