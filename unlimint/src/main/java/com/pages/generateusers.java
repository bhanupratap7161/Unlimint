package com.pages;

import org.testng.Assert;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
 
public class generateusers 
{

	public User  GetBooksDetails() 
	{ 
		
		RestAssured.baseURI = "https://randomuser.me/api/"; 
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "");
		int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200, "Correct status code returned");

		Gson gson = new Gson();
		User user= gson.fromJson(response.asString(), User.class);
 
        return user;
	}



	
}