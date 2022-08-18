package GetRequest;

import BaseURL.BaseURLNew;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import test_data.JsonNewNewData;
import utils.JsonUtilNew;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Get14ObjectMapperNew extends BaseURLNew {
/*
      Given
	        https://jsonplaceholder.typicode.com/todos/198
        When
	 		I send GET Request to the URL
	 	Then
	 		Status code is 200
	 		And response body is like {
									    "userId": 10,
									    "id": 198,
									    "title": "quis eius est sint explicabo",
									    "completed": true
									  }
     */
@Test

    public void get01(){
        spec.pathParams("pp1","todos","pp2",198);
    JsonNewNewData obj =new JsonNewNewData();
    String expectedData=obj.jsonString(10,"quis eius est sint explicabo",true).toString();
    System.out.println(expectedData);

        Map<String,Object> expectedDataMap=JsonUtilNew.convertJsonToJava(expectedData,HashMap.class);
        System.out.println(expectedDataMap);

    Response response=given().spec(spec).when().get("{pp1}/{pp2}");
    Map<String,Object>actualData=JsonUtilNew.convertJsonToJava(response.asString(),HashMap.class);

    System.out.println(actualData);
    Assert.assertEquals(expectedDataMap.get("userId"),actualData.get("userId"));
    Assert.assertEquals(expectedDataMap.get("title"),actualData.get("title"));
    Assert.assertEquals(expectedDataMap.get("completed"),actualData.get("completed"));

    }



}
