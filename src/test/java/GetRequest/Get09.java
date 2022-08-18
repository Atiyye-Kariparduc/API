package GetRequest;

import BaseURL.herokuapp_base;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

/*
Given
            https://restful-booker.herokuapp.com/booking/3418
        When
            I send GET Request to the url
        Then
            Response body should be like that;
            {
        "firstname": "James",
        "lastname": "Brown",
        "totalprice": 111,
        "depositpaid": true,
        "bookingdates": {
            "checkin": "2018-01-01",
            "checkout": "2019-01-01"
        },
        "additionalneeds": "Breakfast"
         }
 */
public class Get09 extends herokuapp_base {
    @Test
    public void get09(){
spec.pathParams("pp1","booking","pp2",2461);
Map<String,String> expectedbooking=new HashMap<>();
expectedbooking.put("checkin","2018-01-01");
expectedbooking.put("checkout","2019-01-01");
Map<String,Object>expectedData=new HashMap<>();
expectedData.put("firstname","James");
        expectedData.put("lastname","Brown");
        expectedData.put("totalprice",111);
        expectedData.put("depositpaid",true);
        expectedData.put("bookingdates",expectedbooking);
        expectedData.put("additionalneeds","Breakfast");

        Response response=given().spec(spec).when().get("{pp1}/{pp2}");
        Map<String,Object>responseMap=response.as(HashMap.class);
        Assert.assertEquals(expectedbooking.get("checkin"),((Map)responseMap.
                get("bookingdates")).
                get("checkin"));

        Assert.assertEquals(expectedbooking.get("checkout"),((Map)responseMap.
                get("bookingdates")).
                get("checkout"));




    }
}
