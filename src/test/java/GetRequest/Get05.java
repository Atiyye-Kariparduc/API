package GetRequest;

import BaseURL.herokuapp_base;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get05 extends herokuapp_base {
    @Test

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

    public void get05(){
spec.pathParam("pp1","booking").
        queryParams("firstname","Johhny","lastname","Dear");
        Response response=given().spec(spec).when().get("/{pp1}");
//response.then().assertThat().statusCode(200);
        Assert.assertEquals(200,response.getStatusCode());
        Assert.assertTrue(response.asString().contains("bookingid"));



    }
}
