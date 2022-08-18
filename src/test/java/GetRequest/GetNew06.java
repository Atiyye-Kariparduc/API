package GetRequest;

import BaseURL.herokuapp_base;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;





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

public class GetNew06 extends herokuapp_base {
    @Test
    public void getmew06(){
spec.pathParams("pp1","booking","pp2",700);
        Response response=given().spec(spec).when().get("/{pp1}/{pp2}");
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);
               /* body("firstname",equalTo("Jessica"),
                       "lastname",equalTo("Wilson"),
                        "totalprice",equalTo("60"),
                        "depositpaid",equalTo("false"),
                        "bookingdates.checkin",equalTo("2023-01-03"),
                        "bookingdates.checkout",equalTo("2023-01-17"),
                        "additionalneeds",equalTo("breakfast"));

                */
JsonPath json=response.jsonPath();
Assert.assertEquals(json.getString("firstname"),"Sally");
Assert.assertEquals(json.get("lastname"),"Wilson");
Assert.assertEquals(json.getInt("totalprice"),60);
Assert.assertEquals(json.getBoolean("depositpaid"),false);
Assert.assertEquals(json.get("bookingdates.checkin"),"2023-01-03");
Assert.assertEquals(json.get("bookingdates.checkout"),"2023-01-17");
Assert.assertEquals(json.get("additionalneeds"),"breakfast");

        SoftAssert softAssert=new SoftAssert();
softAssert.assertEquals(json.getString("firstname"),"Sally");
softAssert.assertEquals(json.get("lastname"),"Wilson");
softAssert.assertEquals(json.getInt("totalprice"),60);
        softAssert.assertEquals(json.getBoolean("depositpaid"),false);
        softAssert.assertEquals(json.get("bookingdates.checkin"),"2023-01-03");
        softAssert.assertEquals(json.get("bookingdates.checkout"),"2023-01-17");
        softAssert.assertEquals(json.get("additionalneeds"),"breakfast");
softAssert.assertAll();
    }
}
