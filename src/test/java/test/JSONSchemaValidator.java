package test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class JSONSchemaValidator {

	@Test
	public void validateGetJsonSchema() {

		Response response = RestAssured.get("https://reqres.in/api/users?page=2");

		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		given().get("https://reqres.in/api/users?page=2").then().assertThat()
				.body(matchesJsonSchemaInClasspath("schema.json")).body("data[0].first_name", equalTo("Michael"));

	}

}
