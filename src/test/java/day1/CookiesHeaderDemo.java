package day1;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

import java.util.Map;


public class CookiesHeaderDemo {
	
	@Test(priority=1)
	void testCookies()
	{
		given()
		
		.when()
		
		.get("https://www.google.com/")
		
		.then()
		//cookie with key and value 
		.cookie("AEC","Ae3NU9PqosCM8wH4yZ-zUFjPvZKvQNntUkxyTkIXJA0QjVuXsGB6yp966uA")
		.log().all();
	}

	@Test(priority=2)
	void testCookiesInfo()
	{
		Response res = given()
		
		.when()
		
		.get("https://www.google.com/");
		
		//get single cookie information
		String cookie_value = res.getCookie("AEC");
		System.out.println("Value of cookie =====>"+cookie_value);
		
		//get all cookie information
		Map<String, String> cookies_value = res.getCookies();
//		System.out.println(cookies_value.keySet());
		
		//to get value of cookie
		for(String k:cookies_value.keySet())
		{
			String cookie_value1 = res.getCookie(k);
			System.out.println(k+"    "+cookie_value1);
			
		}
	}
	

}
