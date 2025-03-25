package test;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class localPostAPIRequest {
	
	
	@Test
	public void postAPIRequest() {
		
		//Map<String, String> map = new HashMap<String, String>();
//		map.put("fname", "Dev");
//		map.put("lname", "philip");
		
		
		JSONObject response = new JSONObject();
		response.put("fname", "John");
		response.put("lname", "Smith");
		response.put("roleId", 2);
		
		//baseURI = "http://localhost:3000";
		
		given().
			baseUri("http://localhost").
			port(3000).
			body(response.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201);
		
		
	}
	
	
	
	@Test
	public void putAPIRequest() {
		
		JSONObject response = new JSONObject();
		response.put("fname", "Albert");
		response.put("lname", "Einstein");
		response.put("roleId", 3);
		
		//baseURI = "http://localhost:3000";
		
		given().
			baseUri("http://localhost").
			port(3000).
			body(response.toJSONString()).
		when().
			put("/users/5725").
		then().
			statusCode(200).log().all();
		
	}
	
	
	
	@Test
	
	public void patchAPIRequest() {
		
		JSONObject response = new JSONObject();
		response.put("fname", "Bill");
		
		baseURI = "http://localhost:3000";
		
		given().
			body(response.toJSONString()).
		when().
			patch("/users/2").
		then().
			statusCode(200).log().all();
		
	}
	
	
	
	
	@Test
	public void deleteAPIRequest() {
		
//		JSONObject response = new JSONObject();
//		response.put("fname", "Bill");
		
		baseURI = "http://localhost:3000";
		
		when().
			delete("/users/5725").
		then().
			statusCode(200).log().all();
		
	}

}
