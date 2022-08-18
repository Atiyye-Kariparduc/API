package patch_request;

import BaseURL.BaseURLNew;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import test_data.JsonNewData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PatchNew01 extends BaseURLNew {
    @Test
    public void patchnew(){

      /*
     Given
	        1) https://jsonplaceholder.typicode.com/todos/198
	        2) {
                 "title": "Wash the dishes"
               }
        When
	 		I send PATCH Request to the Url
	    Then
	   	   Status code is 200
	   	   And response body is like   {
									    "userId": 10,
									    "title": "Wash the dishes",
									    "completed": true,
									    "id": 198
									   }


       */

        spec.pathParams("pp1","todos","pp2",198);
        JsonNewData obj=new JsonNewData();
        Map<String,Object> requestData=obj.expectedData(null,"Wash the dishes",null,null,null);
        Response response=given().spec(spec).contentType(ContentType.JSON).body(requestData).when().patch("{pp1}/{pp2}");
        Map<String,Object>actualData=response.as(HashMap.class);

        Assert.assertEquals(requestData.get("title"),actualData.get("title"));
        Assert.assertEquals(200,response.getStatusCode());
    }
}
