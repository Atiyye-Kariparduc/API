package test_data;

import java.util.HashMap;
import java.util.Map;

public class HerOkuNewData {

    /*
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
    public Map<String, String> expectedbookingData(String checkin, String checkout) {
        Map<String, String> bookingDatesMap = new HashMap<>();
        bookingDatesMap.put("checkin", checkin);
        bookingDatesMap.put("checkout", checkout);
        return bookingDatesMap;
    }

    public Map<String, Object> expectedData(String firstname, String lastname, int totalprice, Boolean depositpaid, Map<String, String> bookingdates, String additionalneeds) {
        Map<String, Object> expectedMap = new HashMap<>();
        expectedMap.put("firstname", firstname);
        expectedMap.put("lastname", lastname);
        expectedMap.put("totalprice", totalprice);
        expectedMap.put("depositpaid", depositpaid);
        expectedMap.put("bookingdates", bookingdates);

        expectedMap.put("additionalneeds", additionalneeds);
        if (additionalneeds == null) {
            expectedMap.remove("additionalneeds");
        }
            return expectedMap;
        }
    }

