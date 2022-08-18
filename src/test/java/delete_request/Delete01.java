package delete_request;

import BaseURL.BaseURLNew;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Delete01 extends BaseURLNew {
    @Test
    public void delete01(){
        /*
        Given
            https://jsonplaceholder.typicode.com/todos/198
        When
	 		I send DELETE Request to the Url
	 	Then
		 	Status code is 200
		 	And Response body is { }
     */

        spec.pathParams("pp1","todos","pp2",198);
        Map<String,Object> expecteddata=new HashMap<>();
        Response response=given().spec(spec).contentType(ContentType.JSON).when().delete("{pp1}/{pp2}");
        Map<String,Object>actualData=response.as(HashMap.class);
        Assert.assertTrue(actualData.size()==0);


    }
}
