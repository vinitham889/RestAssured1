package day1;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class HeaderDemo {
	
	@Test(priority=1)
	
	void testHeadre()
	{
		given()
		
		.when()
		.get("https://www.google.com/")
		
		.then()
		.header("Content-Type", "text/html; charset=ISO-8859-1")
		.and()
		.header("Content-Encoding","gzip")
		.and()
		.header("Server", "gws");
	}
    @Test(priority=2)
	
	void testHeadres()
	{
		Response res = given()
		
		.when()
		.get("https://www.google.com/");
		
		//get single hearder info
	     String headerValue = res.getHeader("Content-Type");
	     System.out.println("The value of Content-Type header is "+headerValue);
	     
	     //get all headers
	     
	     Headers myHeaders = res.getHeaders();
	     for(Header hd:myHeaders)
	     {
	    	 System.out.println(hd.getName()+"   "+hd.getValue());
	     }
	}
	

}
