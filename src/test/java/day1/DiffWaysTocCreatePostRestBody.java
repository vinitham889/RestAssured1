package day1;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

public class DiffWaysTocCreatePostRestBody {
	/*Diff ways to create post request body
	 * 1) Using HashMap
	 * 2) Using org.JSON
	 * 3) POJO class
	 * 4) using external json file data
	 * 
	 */
	
	
	//1) Using HashMap
	  //@Test
        void testPostUsingHashMap() {
		HashMap data = new HashMap();
		data.put("name", "morpheus");
		data.put("job", "leader");
		
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("https://reqres.in/api/users")
		
		.then()
		.statusCode(201)
//		.body("name", equalTo("morpheus"))
		.header("Content-Type","application/json; charset=utf-8")
		.log().all();
		
		
	}
        //@Test
        //2) Using org.JSON [add org.json dependency]
        void testPostUsingJSON() {
		JSONObject data = new JSONObject();
		data.put("name", "morpheus");
		data.put("job", "leader");
		
		given()
		.contentType("application/json")
		.body(data.toString())
		
		.when()
		.post("https://reqres.in/api/users")
		
		.then()
		.statusCode(201)
//		.body("name", equalTo("morpheus"))
		.header("Content-Type","application/json; charset=utf-8")
		.log().all();
		
		
	}
        //@Test
        //3) POJO class [create separate POJO class]
        void testPostUsingPOJO() {
        	POJO_PostRequest data = new POJO_PostRequest();
        	data.setName("morpheus");
        	data.setJob("leader");


		
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("https://reqres.in/api/users")
		
		.then()
		.statusCode(201)
//		.body("name", equalTo("morpheus"))
		.header("Content-Type","application/json; charset=utf-8")
		.log().all();
		
		
	}
        @Test(priority = 1)
        //4) using external json file data
        void testPostUsingJsonFile() throws FileNotFoundException {
        	
        	File file = new File(".\\body.json");
        	FileReader fr = new FileReader(file);
        	
        	JSONTokener jt = new JSONTokener(fr);
        	
        	JSONObject data = new JSONObject(jt);



		
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("https://reqres.in/api/users")
		
		.then()
		.statusCode(201)
//		.body("name", equalTo("morpheus"))
		.header("Content-Type","application/json; charset=utf-8")
		.log().all();
		
		
	}
	  
	  
        
	  
	  @Test
	  void testDelete()
	  {
		  given()
		  .delete("https://reqres.in/api/users/2")
		  .then()
		  .statusCode(204);
	  }
	  
	 

}
