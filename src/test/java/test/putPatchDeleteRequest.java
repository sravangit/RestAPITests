package test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;



//PUT, PATCH AND DELETE REQUESTS
public class putPatchDeleteRequest {
	
	
	@Test
	
	public void putRequest() {
		
		baseURI = "https://reqres.in/api";
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "thomas");
		map.put("job", "zion resident");
		
		JSONObject request = new JSONObject(map);
		
		
		given().
			header("Content-Type", "application/json").
			body(request.toJSONString()).
		when().
			put("/users/2").
		then().
			assertThat().body("name", equalTo("thomas")).
			and().
			statusCode(200).
			log().all();
		
	}
	
	
	@Test
	public void patchRequest() {
		
		baseURI = "https://reqres.in";
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "morpheus");
		map.put("job", "zion resident");
		
		JSONObject request = new JSONObject(map);
		
		
		given().
		header("Content-Type", "application/json").
			body(request.toJSONString()).
		when().
			patch("/api/users/2").
		then().
			statusCode(200).
			log().all();
		
	}
	
	
	
	@Test
	public void deleteRequest() {
		
		baseURI = "https://reqres.in";
		
		

		when().
			delete("/api/users/2").
		then().
			statusCode(204).
			log().all();
		
	}
	
	
	
	

}
