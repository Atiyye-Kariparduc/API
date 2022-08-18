package GetRequest;

import BaseURL.BaseURLNew;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojo.JsonPlaceHolderPojo;
import test_data.JsonNewData;
import utils.JsonUtil;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Get14ObjectMapper extends BaseURLNew {

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
    public void get01ObjectMapper(){

        spec.pathParams("pp1","todos","pp2",198);
        String expectedData="{\n" +
                "  \"userId\": 10,\n" +
                "  \"id\": 198,\n" +
                "  \"title\": \"quis eius est sint explicabo\",\n" +
                "  \"completed\": true\n" +
                " }";
        JsonNewData obj=new JsonNewData();
         expectedData=obj.expectedDataInString(10,"quis eius est sint explicabo",true);
       Map<String,Object> expectedDataMap=JsonUtil.convertJsonToJavaObject(expectedData, HashMap.class);
        System.out.println(expectedDataMap);

       Response response=given().spec(spec).when().get("{pp1}/{pp2}");

       Map<String,Object>actualData=JsonUtil.convertJsonToJavaObject(response.asString(),HashMap.class);

        Assert.assertEquals(expectedDataMap.get("userId"),actualData.get("userId"));
    }
    public void get02ObjectMapper(){
        spec.pathParams("pp1","todos","pp2",198);
        JsonNewData obj=new JsonNewData();
       String expectedData= obj.expectedDataInString(10,"quis eius est sint explicabo",true);
        JsonPlaceHolderPojo expectedDataPojo=JsonUtil.convertJsonToJavaObject(expectedData, JsonPlaceHolderPojo.class);
        Response response=given().spec(spec).when().get("{pp1}/{pp2}");

        JsonPlaceHolderPojo actualData=JsonUtil.convertJsonToJavaObject(response.asString(),JsonPlaceHolderPojo.class);

    }
}
