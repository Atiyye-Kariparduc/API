package Put;

import BaseURL.BaseURLNew;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import test_data.JsonNewData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Put01 extends BaseURLNew {
@Test
    public void put01(){
    /*
        Given
	        1) https://jsonplaceholder.typicode.com/todos/198
	        2) {
                 "userId": 21,
                 "title": "Wash the dishes",
                 "completed": false
               }
        When
	 		I send PUT Request to the Url
	    Then
	   	   Status code is 200
	   	   And response body is like   {
									    "userId": 21,
									    "title": "Wash the dishes",
									    "completed": false
									   }
     */
    spec.pathParams("pp1","todos","pp2",198);
    JsonNewData obj= new JsonNewData();
    Map<String,Object> requestMap=obj.expectedData(21,"Wash the dishes",false,null,null);
    Response response=given().spec(spec).contentType(ContentType.JSON).body(requestMap).when().put("{pp1}/{pp2}");
    Map<String,Object>actualData=response.as(HashMap.class);
    Assert.assertEquals(200,response.getStatusCode());
    Assert.assertEquals(requestMap.get("userId"),actualData.get("userId"));
    Assert.assertEquals(requestMap.get("title"),actualData.get("title"));
    Assert.assertEquals(requestMap.get("completed"),actualData.get("completed"));

}
}
