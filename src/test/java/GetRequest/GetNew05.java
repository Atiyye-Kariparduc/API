package GetRequest;

import BaseURL.herokuapp_base;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class GetNew05 extends herokuapp_base {
    /*
Given
            https://restful-booker.herokuapp.com/booking
        When
            User send a request to the URL
        Then
            Status code is 200
	  	And
	  		Among the data there should be someone whose firstname is "Adamz" and last name is "Dear"
 */

    @Test
        public void getnew05(){
spec.pathParam("pp1","booking");
spec.queryParams("firstname","Jim","lastname","Brown");
        Response response=given().spec(spec).when().get("{pp1}");
        Assert.assertEquals(200,response.getStatusCode());
//Assert.assertEquals(response.asString().contains("bookingid"));

    }
}
