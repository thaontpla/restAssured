package com.onemount;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GlobalContainsDemo {
	
	@BeforeSuite
	public void setup() {
		RestAssured.baseURI = "https://reqres.in/";
		RestAssured.basePath = "api/users";
		RestAssured.rootPath = "data";
	}
	
	@Test
	public void testOneUsing() {
		RestAssured.get()
			.then()
			.body("id[0]", Matchers.is(1));
	}
	
	@Test
	public void testTowUsing() {
		RestAssured.get()
			.then()
			.body("id[1]", Matchers.is(2));
	}

}
