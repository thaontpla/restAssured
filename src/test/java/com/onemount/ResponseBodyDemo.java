package com.onemount;

import static org.testng.Assert.assertEquals;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class ResponseBodyDemo {
	
	public static final String BASE_URL = "https://api.github.com/rate_limit";
	
	@Test
	public void jsonPathReturnMap() {
		
		Response response = RestAssured.get(BASE_URL);
		
		ResponseBody<?> body = response.body();
		
		JsonPath jsonPath = body.jsonPath();
		
		JsonPath jsonPath2 = response.body().jsonPath();
		
		Map<String, String> fulljson = jsonPath2.get();  // không có get(), chỉ là một đường dẫn nhận các tập hợp
		Map<String, String> subMap = jsonPath2.get("resources");
		Map<String, String> subMap2 = jsonPath2.get("resources.core");
		
		int value = jsonPath.get("resources.core.limit");
		int value2 = jsonPath.get("resources.graphql.remaining");
		
		System.out.println(fulljson);
		System.out.println(subMap);
		System.out.println(subMap2);
		System.out.println(value);
		System.out.println(value2);
		
		assertEquals(value, 60);
		assertEquals(value2, 0);
	}

}
