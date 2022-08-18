package Post;

import BaseURL.BaseURLNew;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import test_data.JsonDataType;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Post02 extends BaseURLNew {
    @Test
    public void put02(){
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
                                    }
         */
        spec.pathParam("pp1","todos");
        JsonDataType expectedData=new JsonDataType();
        Map<String,Object> expectedData1=expectedData.getExpectedData(55,"Tidy your room",false);

        Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedData1).when().post("{pp1}");
        Map<String,Object>actualData=response.as(HashMap.class);
        Assert.assertEquals("Statuscode",response.getStatusCode());


    }
}
