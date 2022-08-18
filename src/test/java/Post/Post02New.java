package Post;

import BaseURL.BaseURLNew;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import test_data.JsonNewData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Post02New extends BaseURLNew {
    /*
        Given
           1) https://jsonplaceholder.typicode.com/todos
           2)  {
                 "userId": 55,
                 "title": "Tidy your room",
                 "completed": false
              }
        When
            I send POST Request to the Url
        Then
            Status code is 201
        And
            response body is like {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    */
     @Test
    public  void put02new(){
         spec.pathParam("pp1","todos");

         JsonNewData obj=new JsonNewData();
         Map<String,Object>expectedMap =obj.expectedData(55,"Tidy your room",false,null,null);
         Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedMap).when().post("{pp1}");
         Map<String,Object>actualData=response.as(HashMap.class);
         Assert.assertEquals(201,response.getStatusCode());
         Assert.assertEquals(expectedMap.get("userId"),actualData.get("userId"));
         Assert.assertEquals(expectedMap.get("title"),actualData.get("title"));
         Assert.assertEquals(expectedMap.get("completed"),actualData.get("completed"));


     }

}
