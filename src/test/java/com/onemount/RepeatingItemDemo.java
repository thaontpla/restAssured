package com.onemount;

import io.restassured.RestAssured;
//import static org.hamcrest.Matchers.equalTo;
import io.restassured.parsing.Parser;

import org.hamcrest.Matchers;
import org.hamcrest.core.StringEndsWith;
import org.testng.annotations.Test;

public class RepeatingItemDemo {
	
	public static final String BASE_URL = "https://reqres.in/api/users";
	
	@Test
	public void repeatingItem() {
		RestAssured.get(BASE_URL)
			.then()
			.using()
				.defaultParser(Parser.JSON)
			.body("data.id[0]", Matchers.equalTo(1))
			.body("data.first_name[0]", Matchers.equalTo("George"))
			.body("data.first_name", Matchers.hasItem("Eve"))
			.body("data.first_name", Matchers.hasItems("Eve","Emma"))
			.body("data.first_name", Matchers.hasItem(Matchers.endsWith("ma")))
		;
		
		
	}

}
