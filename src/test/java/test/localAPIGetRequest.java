package test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class localAPIGetRequest {
	
	
	
	@Test
	public void getAPIRequest() {
		
		//baseURI = "http://localhost";
		
		Response response = RestAssured.get("http://localhost:3000/users/1");
		System.out.println(response.getBody().asString());
		
		given().
			baseUri("http://localhost").
			port(3000).
		when().
			get("/users/1").
		
		then().assertThat().
			body("fname", equalTo("Tom")).
			and().
			statusCode(200).log().all();
		
		
	}

}
