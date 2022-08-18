package Post;

import BaseURL.HerokuNew_url;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import test_data.HerOkuNewData;


import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;


public class Post01New extends HerokuNew_url {
    /*
   Given
           1) https://restful-booker.herokuapp.com/booking
           2) {
                "firstname": "John",
                "lastname": "Doe",
                "totalprice": 11111,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2021-09-09",
                    "checkout": "2021-09-21"
                 }
              }
       When
           I send POST Request to the Url
       Then
           Status code is 200
           And response body should be like {
                                               "bookingid": 5315,
                                               "booking": {
                                                   "firstname": "John",
                                                   "lastname": "Doe",
                                                   "totalprice": 11111,
                                                   "depositpaid": true,
                                                   "bookingdates": {
                                                       "checkin": "2021-09-09",
                                                       "checkout": "2021-09-21"
                                                   }
                                               }
                                            }
    */
    @Test
    public void post01new() {
        spec.pathParam("pp1", "booking");
        HerOkuNewData expectedData = new HerOkuNewData();

        Map<String, String> bookingDatesMap = expectedData.expectedbookingData("2021-09-09", "2021-09-21");
        Map<String, Object> bookingMap = expectedData.expectedData("Johnny", "Doe", 11111, true, bookingDatesMap, null);
        System.out.println(bookingMap);

        Response response = given().spec(spec).contentType(ContentType.JSON).body("bookingMap").when().post("{pp1}");
        Map<String, Object> actualData = response.as(HashMap.class);
        //response.then().assertThat().statusCode(200);
        Assert.assertEquals(bookingMap.get("firstname"), ((Map) actualData.get("booking")).get("firstname"));
        Assert.assertEquals(bookingMap.get("lastname"), ((Map) actualData.get("booking")).get("lastname"));

        Assert.assertEquals(bookingMap.get("totalprice"), ((Map) actualData.get("booking")).get("totalprice"));
        Assert.assertEquals(bookingMap.get("depositpaid"), ((Map) actualData.get("booking")).get("depositpaid"));
        Assert.assertEquals(bookingDatesMap.get("checkin"), ((Map) ((Map) actualData.get("booking")).get("bookingdates")).get("checkin"));
        Assert.assertEquals(bookingDatesMap.get("checkout"), ((Map) ((Map) actualData.get("booking")).get("bookingdates")).get("checkout"));
    }
}
