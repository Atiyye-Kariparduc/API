package GetRequest;

import BaseURL.HerokuNew_url;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import test_data.HerOkuNewData;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;



public class GetNew09 extends HerokuNew_url {
    @Test
    public void get09new(){
        /*
Given
            https://restful-booker.herokuapp.com/booking/11126
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

        spec.pathParams("pp1","booking","pp2",11126);
        HerOkuNewData requestData=new HerOkuNewData();
        Map<String,String> requestbookingMap=requestData.expectedbookingData("2018-01-01","2019-01-01");
        Map<String,Object> requestMap=requestData.expectedData("James","Brown",111,true,requestbookingMap,"Breakfast");

        Response response=given().spec(spec).when().get("/{pp1}/{pp2}");
        Map<String,Object>actualData=response.as(HashMap.class);
        Assert.assertEquals(requestMap.get("firstname"),actualData.get("firstname"));
        Assert.assertEquals(requestMap.get("lastname"),actualData.get("lastname"));
        Assert.assertEquals(requestMap.get("totalprice"),actualData.get("totalprice"));
        Assert.assertEquals(requestMap.get("depositpaid"),actualData.get("depositpaid"));
        Assert.assertEquals(requestMap.get("depositpaid"),actualData.get("depositpaid"));
        Assert.assertEquals(requestbookingMap.get("checkin"),((Map)actualData.get("bookingdates")).get("checkin"));
        Assert.assertEquals(requestbookingMap.get("checkout"),((Map)actualData.get("bookingdates")).get("checkout"));
        Assert.assertEquals(requestMap.get("additionalneeds"),actualData.get("additionalneeds"));

    }
}
