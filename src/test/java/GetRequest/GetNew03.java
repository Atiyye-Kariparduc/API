package GetRequest;

import BaseURL.BaseURLNew;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetNew03 extends BaseURLNew {

    /*
        Given
            https://jsonplaceholder.typicode.com/todos/23
        When
            User send GET Request to the URL
        Then
            HTTP Status Code should be 200
      And
          Response format should be "application/json"
      And
          "title" is "et itaque necessitatibus maxime molestiae qui quas velit",
      And
          "completed" is false
      And
          "userId" is 2
     */

    @Test
    public void Getnew03(){
spec.pathParams("pp1","todos","pp2",23);
        Response response=given().spec(spec).when().get("/{pp1}/{pp2}");
        response.then().assertThat().statusCode(200).
                contentType(ContentType.JSON).
               body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),
                       "completed",equalTo(false),"userId",equalTo(2));


    }




}
