package day1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class PathAndQueryParam {
	@Test
	void testPathAndQueryParam()
	
	{
		//https://reqres.in/api/users?page2&id=5
		
		given()
		.pathParam("mypath","users")// path paramater
		.queryParam("page", 2)//query paramater
		.queryParam("id", 5) //query parameter
		
		.when()
		.get("https://reqres.in/api/{mypath}")
		
		.then()
		.statusCode(200)
		//to get headers
		.log().headers()
		//to get body
		.log().body()
		//to get cookies
		.log().cookies();
	}

}
