package Post;

import BaseURL.BaseURLNew;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.Assert;
import pojo.pojoNew01;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import static io.restassured.RestAssured.given;

public class PostNew03Pojo extends BaseURLNew {
    @Test
    public void postnew03Pojo() {
        /*
    Given
            https://jsonplaceholder.typicode.com/todos
            {
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
        pojoNew01 requestData=new pojoNew01(55,"Tidy your room",false);

        Response response= null;
        try {
            response = given().spec(spec).contentType(ContentType.JSON).body(requestData).when().post("/{pp1}");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        pojoNew01 actualData=response.as(pojoNew01.class);
        response.then().assertThat().statusCode(201);
        Assert.assertEquals(requestData.getUserId(),actualData.getUserId());
        Assert.assertEquals(requestData.getTitle(),actualData.getTitle());
        Assert.assertEquals(requestData.getCompleted(),actualData.getCompleted());



    }
}
