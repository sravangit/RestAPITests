package test;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetandPostRequest {

	@Test
	public void getReq() {

		baseURI = "https://reqres.in/api";
		
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(response.getBody().asString());

		given().
			get("/users?page=2").
		then().
			statusCode(200).
		and().
			body("data[1].email", equalTo("lindsay.ferguson@reqres.in"));

			
	}

}
