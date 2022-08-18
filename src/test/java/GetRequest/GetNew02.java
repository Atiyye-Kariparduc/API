package GetRequest;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class GetNew02 {
    /*
        Given
            https://restful-booker.herokuapp.com/booking/1
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Response body contains "Not Found"
        And
            Response body does not contain "TechProEd"
        And
            Server is "Cowboy"
     */

@Test
    public void Getnew02(){

   String url="https://restful-booker.herokuapp.com/booking/1";
    Response response=given().when().get(url);
    response.then().assertThat().statusCode(404).
            statusLine("HTTP/1.1 404 Not Found");
          Assert.assertTrue(response.asString().contains("Not Found"));
          Assert.assertFalse(response.asString().contains("TechProEd"));
         Assert.assertEquals(response.getHeader("Server"),"Cowboy");


}
}
