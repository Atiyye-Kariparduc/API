package Post;

import BaseURL.BaseURLNew;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojo.JsonPlaceHolderPojo;

import static io.restassured.RestAssured.given;

public class Post03Pojo extends BaseURLNew {
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
    @Test
    public void post03(){
        JsonPlaceHolderPojo requestData=new JsonPlaceHolderPojo(55,"Tidy your room",false);
        Response response=given().spec(spec).contentType(ContentType.JSON).body(requestData).when().put("{pp1}");
    }
}
