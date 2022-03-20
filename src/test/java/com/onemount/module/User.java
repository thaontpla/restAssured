package com.onemount.module;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true) // chỉ quan tâm đến chính xác
public class User {
	
	public String login;
	
	public int id;
	@JsonProperty("public_repos") //jsonđược ngăn cách dấu phẩy
	public int publicRepos;

	public String getLogin() {
		return login;
	}

	public int getId() {
		return id;
	}

	public int getPublicRepos() {
		return publicRepos;
	}
	

	
	

}
