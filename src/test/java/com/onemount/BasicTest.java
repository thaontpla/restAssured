package com.onemount;


import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.xml.bind.v2.schemagen.xmlschema.List;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class BasicTest {
	
	public static final String BASE_URL = "https://api.github.com";
	
	@Test
	public void conveniunceMehtod() {
		
		Response response = RestAssured.get(BASE_URL);
		Assert.assertEquals(response.getStatusCode(),200);
		Assert.assertEquals(response.getContentType(),"application/json; charset=utf-8");
		RestAssured.get(BASE_URL).peek();
	}
	@Test
	public void generalHeader() {
		
		Response response = RestAssured.get(BASE_URL);
		Assert.assertEquals(response.getHeader("Server"), "GitHub.com");
		Assert.assertEquals(response.getHeader("X-RateLimit-Limit"), "60");
		
		//or
		Assert.assertEquals(Integer.parseInt(response.getHeader("X-RateLimit-Limit")), 60);
	}
	
	@Test
	public void getHeader() {
		Response response = RestAssured.get(BASE_URL);
		Headers headers = response.getHeaders();
		String val = headers.getValue("header1");// lấy giá trị cho một tiêu đề cụ thể
		int size = headers.size(); // lấy số lượng tất cả các tiêu đề
		java.util.List<Header> list = headers.asList();//chuyển đổi thành danh sách java truyền thông
		boolean isPresent = headers.hasHeaderWithName("header2");// kiểm tra có một tiêu đề cụ thể hay không
		Assert.assertTrue(isPresent);
		
	}
	
	@Test
	public void timeExemple() {
		Response response = RestAssured.get(BASE_URL);
		System.out.println(response.getTime());
		System.out.println(response.getTimeIn(TimeUnit.MINUTES));
	}

}
