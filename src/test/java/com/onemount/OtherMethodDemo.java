package com.onemount;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class OtherMethodDemo {
	
	public static final String BASE_URL = "https://api.github.com/user/repos";
	public static final String TOKEN = "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";
	
	@Test(description = "Create a repo")
	public void postTest() {
		RestAssured
			.given()
				.header("Authorization", "token" + TOKEN )
				.body("{\"name\": \"deleteme\"}")
			.when()
				.post(BASE_URL)
			.then()
				.statusCode(201);
			
	}
	
	@Test(description = "Update a repo")
	public void patchTest() {
		RestAssured
			.given()
				.header("Authorization", "token" + TOKEN )
				.body("{\"name\": \"deleteme-patch\"}")
			.when()
				.post("")
			.then()
				.statusCode(200);
			
	}
	
	@Test(description = "Delete a repo")
	public void deleteTest() {
		RestAssured
			.given()
				.header("Authorization", "token" + TOKEN )
			.when()
				.post("")
			.then()
				.statusCode(204);
			
	}

}
