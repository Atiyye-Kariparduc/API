package Post;

import BaseURL.herokuapp_base;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import test_data.herokuTest;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Post01 extends herokuapp_base {
@Test
    public void put01(){
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

    spec.pathParam("pp1","booking");
    herokuTest expected=new herokuTest();
    Map<String,String> bookingdataMap=expected.bookingdatesSetUp("2021-09-09","2021-09-21");
    Map<String,Object>expectedDataMap= expected.expectedDataSetUp("John","Doe",11111,true,bookingdataMap);


    Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedDataMap).when().put("{pp1}");

    Map<String,Object>actualData=response.as(HashMap.class);
    Assert.assertEquals(expectedDataMap.get("firstname"),((Map)actualData.get("booking")).get("firstname"));
    Assert.assertEquals(expectedDataMap.get("lastname"),((Map)actualData.get("booking")).get("lastname"));
    Assert.assertEquals(expectedDataMap.get("totalprice"),((Map)actualData.get("booking")));

}
}
