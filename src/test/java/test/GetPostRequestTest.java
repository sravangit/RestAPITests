package test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;


//GET AND POST REQUESTS

public class GetPostRequestTest {

	@Test
	public void getRequest() {
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");


		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		given().
		get("https://reqres.in/api/users?page=2").
		then().body("data[0].first_name", equalTo("Michael"));
	}
	
	@Test
	
	public void anotherGetRequest() {
		
		given().
			header("Content-Type", "application/json").
		and().expect().
			body("data[0].first_name", equalTo("Michael")).
		when().
			get("https://reqres.in/api/users?page=2");
		
	}
	
	@Test
	public void postRequest() {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "smith");
		map.put("job", "manager");
		
		
		JSONObject request = new JSONObject(map);
		
		baseURI= "https://reqres.in/api";		
		
		given().header("Content-Type", "application/json").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
				body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).log().all();
		
	}

}
