package GetRequest;

import BaseURL.BaseURLNew;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.Assert;
import test_data.JsonDataType;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Get08 extends BaseURLNew {

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
    @Test
    public void get08(){
        spec.pathParams("pp1","todos","pp2",2);
        Map<String,Object>expectedData=new HashMap<>();
        expectedData.put("userId",1);
        expectedData.put("title","quis ut nam facilis et officia qui");
        expectedData.put("completed",false);
        expectedData.put("Status code",200);
        expectedData.put("Via","1.1 vegur");
        expectedData.put("Server","cloudflare");

        Response response=given().spec(spec).when().get("{pp1}/{pp2}");
        Map<String,Object>actualdata=response.as(HashMap.class);
        System.out.println(actualdata);
        Assert.assertEquals(actualdata.get("userId"),expectedData.get("userId"));
Assert.assertEquals(actualdata.get("title"),expectedData.get("title"));
Assert.assertEquals(actualdata.get("completed"),expectedData.get("completed"));
        Assert.assertEquals(expectedData.get("Status code"),response.getStatusCode());
        Assert.assertEquals(actualdata.get("Via"),response.getHeader("Via"));
        Assert.assertEquals(actualdata.get("Server"),response.getHeader("Server"));


        JsonDataType expectData=new JsonDataType();

    }
}
