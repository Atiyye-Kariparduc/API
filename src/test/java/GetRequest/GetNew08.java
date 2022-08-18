package GetRequest;

import BaseURL.BaseURLNew;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import test_data.JsonNewData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetNew08 extends BaseURLNew {
    @Test
    public void getnew08() {

         /*
    Given
            https://jsonplaceholder.typicode.com/todos/2
        When
            I send GET Request to the URL
        Then
            Status code is 200
            And "completed" is false
            And "userId" is 1
            And "title" is "quis ut nam facilis et officia qui"
            And header "Via" is "1.1 vegur"
            And header "Server" is "cloudflare"
            {
                "userId": 1,
                "id": 2,
                "title": "quis ut nam facilis et officia qui",
                "completed": false
            }
     */

        spec.pathParams("pp1","todos","pp2",2);

        JsonNewData requestData=new JsonNewData();
      Map<String,Object>requestmap =requestData.expectedData(1,"quis ut nam facilis et officia qui",false,"1.1 vegur","cloudflare");

        Response response=given().spec(spec).when().get("{pp1}/{pp2}");
        Map<String,Object> actualData=response.as(HashMap.class);
        Assert.assertEquals(200,response.getStatusCode());
        Assert.assertEquals(requestmap.get("Via"),response.getHeader("Via"));
        Assert.assertEquals(requestmap.get("Server"),response.getHeader("Server"));
        Assert.assertEquals(requestmap.get("userId"),actualData.get("userId"));
        Assert.assertEquals(requestmap.get("title"),actualData.get("title"));
        Assert.assertEquals(requestmap.get("completed"),actualData.get("completed"));




    }
}
