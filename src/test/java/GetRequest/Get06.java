package GetRequest;
import BaseURL.herokuapp_base;
import io.restassured.response.Response;
import org.junit.Test;


import static io.restassured.RestAssured.given;

public class Get06 extends herokuapp_base {
    @Test
    public void get06(){


        /*
        Given
            https://restful-booker.herokuapp.com/booking/555
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is “application/json”
        And
            Response body should be like;
          {
            "firstname": "Sally",
            "lastname": "Brown",
            "totalprice": 111,
            "depositpaid": true,
            "bookingdates": {
                "checkin": "2013-02-23",
                "checkout": "2014-10-23"
            },
            "additionalneeds": "Breakfast"
        }
     */
        spec.pathParams("pp1","booking","pp2",555);
        Response response=given().spec(spec).when().get("{pp1},{pp2}");
      //  response.then().assertThat().statusCode(200).
                //contentType(ContentType.JSON).body("firstname",equalTo("Sally"),
                       // "lastname",equalTo("Brown"),"totalprice",equalTo(111),
                        //"depositpaid",equalTo("true"),
                        //"bookingdates.checkin",equalTo("2013-02-23"),
                       // "bookingdates.checkout",equalTo("2014-10-23"),
                      //  "additionalneeds",equalTo("Breakfast"));


    }
}
