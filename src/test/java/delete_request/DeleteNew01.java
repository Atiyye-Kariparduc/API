package delete_request;

import BaseURL.BaseURLNew;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class DeleteNew01 extends BaseURLNew {
    @Test
    public void deletenew01(){
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
        Response response=given().spec(spec).when().delete("{pp1}/{pp2}");
        Map<String,Object>actualData= response.as(HashMap.class);
        response.then().assertThat().statusCode(200);
        Assert.assertTrue(actualData.size()==0);
    }
}
