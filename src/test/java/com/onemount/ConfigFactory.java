package com.onemount;

import java.lang.reflect.Type;

import com.fasterxml.jackson.databind.DeserializationFeature;

import io.restassured.RestAssured;
import io.restassured.config.FailureConfig;
import io.restassured.config.LogConfig;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.config.RedirectConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.listener.ResponseValidationFailureListener;
import io.restassured.path.json.mapper.factory.Jackson2ObjectMapperFactory;

public class ConfigFactory {
	
	public static RestAssuredConfig getOtherDefaultConfig() {
		return null;};

	public static RestAssuredConfig getDefaultConfig() {
		
		ResponseValidationFailureListener failureListener = (reqSpec, resSpec, response) ->
		System.out.printf("We have a failure, " + "response status wass %s and the body contains: %s", response.getStatusCode(), response.getBody().asPrettyString());
		
		return RestAssured.config()
					.logConfig(LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL))
					.failureConfig(FailureConfig.failureConfig().failureListeners(failureListener))
					.redirect(RedirectConfig.redirectConfig().maxRedirects(1))
					.objectMapperConfig(ObjectMapperConfig.objectMapperConfig().jackson2ObjectMapperFactory(getDefaultMapper()));
	}
	
	private static Jackson2ObjectMapperFactory getDefaultMapper() {
		return (Type cls, String charset) -> {
			com.fasterxml.jackson.databind.ObjectMapper om = new com.fasterxml.jackson.databind.ObjectMapper();
			om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return om;
		
	};
	}
}
