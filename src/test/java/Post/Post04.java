package Post;

import BaseURL.HerokuNew_url;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojo.BookingDatesPojo;
import pojo.BookingPojo;
import pojo.BookingResponseBodyPojo;


import static io.restassured.RestAssured.*;

public class Post04 extends HerokuNew_url {
    @Test
    public void post04p() {
        /*
         Given
            https://restful-booker.herokuapp.com/booking
            {
                "firstname": "Ali",
                "lastname": "Can",
                "totalprice": 999,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2021-09-21",
                    "checkout": "2021-12-21"
                 }
                 "additionalneeds": "Breakfast with white tea, Dragon juice"
             }
        When
 		    I send POST Request to the URL
 	    Then
 		    Status code is 200
 		And
 		    Response body is like {
 		                            "bookingid": 16,
 		                            "booking" :{
                                        "firstname": "Ali",
                                        "lastname": "Can",
                                        "totalprice": 999,
                                        "depositpaid": true,
                                        "bookingdates": {
                                            "checkin": "2021-09-21",
                                            "checkout": "2021-12-21"
                                        }
                                    "additionalneeds": "Breakfast with white tea, Dragon juice"
                                     }
                                  }
         */
        RestAssured.config().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false));
        try {
            spec.pathParam("pp1", "booking");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        BookingPojo expectedData = null;
        BookingResponseBodyPojo payload = null;
        try {
            BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("2021-09-21", "2021-12-21");
            expectedData = new BookingPojo("Ali", "Can", 999, true, bookingDatesPojo, "Breakfast with white tea, Dragon juice");
            payload = new BookingResponseBodyPojo(16, expectedData);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }

        Response response = null;
        try {
            response = given().spec(spec).contentType(ContentType.JSON).body(payload).when().post("/{pp1}");
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }

//tuals(expectedData.getTotalPrice(),actualData.getBooking().getTotalPrice());
       /* Assert.assertEquals(expectedData.getDepositPaid(),actualData.getBooking().getDepositPaid());
        Assert.assertEquals(expectedData.getBookingDates().getCheckin(),actualData.getBooking().getBookingDates().getCheckin());
        Assert.assertEquals(expectedData.getBookingDates().getCheckout(),actualData.getBooking().getBookingDates().getCheckout());

*/


    }
}
