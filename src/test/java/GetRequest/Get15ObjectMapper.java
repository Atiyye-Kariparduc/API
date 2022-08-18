package GetRequest;

import BaseURL.HerokuNew_url;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pojo.BookingPojo;
import utils.JsonUtil;

import static io.restassured.RestAssured.given;

public class Get15ObjectMapper extends HerokuNew_url {
    /*
Given
	            https://restful-booker.herokuapp.com/booking/55
        When
		 		I send GET Request to the URL
		Then
		 		Status code is 200
                {

    "firstname": "Jim",
    "lastname": "Brown",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2022-08-09",
        "checkout": "2022-08-27"
    },
    "additionalneeds": "Breakfast"
                }


     */
    @Test
    public void get01(){

        spec.pathParams("pp1","booking","pp2",55);
String expectedData="                {\n" +
        "\n" +
        "    \"firstname\": \"Jim\",\n" +
        "    \"lastname\": \"Brown\",\n" +
        "    \"totalprice\": 111,\n" +
        "    \"depositpaid\": true,\n" +
        "    \"bookingdates\": {\n" +
        "        \"checkin\": \"2022-08-09\",\n" +
        "        \"checkout\": \"2022-08-27\"\n" +
        "    },\n" +
        "    \"additionalneeds\": \"Breakfast\"\n" +
        "                }";


        BookingPojo expectedDataPojo= JsonUtil.convertJsonToJavaObject(expectedData,BookingPojo.class);

        Response response=given().spec(spec).when().get("{pp1}/{pp2}");
        BookingPojo actualData=JsonUtil.convertJsonToJavaObject(response.asString(),BookingPojo.class);
        Assert.assertEquals(200,response.getStatusCode());
        Assert.assertEquals(expectedDataPojo.getFirstname(),actualData.getFirstname());
        Assert.assertEquals(expectedDataPojo.getLastname(),actualData.getLastname());
        Assert.assertEquals(expectedDataPojo.getTotalPrice(),actualData.getTotalPrice());
        Assert.assertEquals(expectedDataPojo.getDepositPaid(),actualData.getDepositPaid());
        Assert.assertEquals(expectedDataPojo.getAdditionalNeeds(),actualData.getAdditionalNeeds());
        Assert.assertEquals(expectedDataPojo.getBookingDates().getCheckin(),actualData.getBookingDates().getCheckin());
        Assert.assertEquals(expectedDataPojo.getBookingDates().getCheckout(),actualData.getBookingDates().getCheckout());


        SoftAssert soft=new SoftAssert();
        soft.assertEquals(expectedDataPojo.getFirstname(),actualData.getFirstname(),"doesnt match");
        soft.assertEquals(expectedDataPojo.getLastname(),actualData.getLastname(),"First name doesnt match");
        soft.assertEquals(expectedDataPojo.getTotalPrice(),actualData.getTotalPrice(),"Last name doesnt match");
        soft.assertEquals(expectedDataPojo.getDepositPaid(),actualData.getDepositPaid());
        soft.assertEquals(expectedDataPojo.getAdditionalNeeds(),actualData.getAdditionalNeeds());
        soft.assertEquals(expectedDataPojo.getBookingDates().getCheckin(),actualData.getBookingDates().getCheckin());
        soft.assertEquals(expectedDataPojo.getBookingDates().getCheckout(),actualData.getBookingDates().getCheckout());


        soft.assertAll();
    }
}
