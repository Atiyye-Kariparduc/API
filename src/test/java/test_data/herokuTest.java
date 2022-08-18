package test_data;

import java.util.HashMap;
import java.util.Map;

public class herokuTest {
    /*
     "firstname": "John",
                 "lastname": "Doe",
                 "totalprice": 11111,
                 "depositpaid": true,
                 "bookingdates": {
                     "checkin": "2021-09-09",
                     "checkout": "2021-09-21"
     */

    public Map<String,String>bookingdatesSetUp(String checkin,String checkout){
        Map<String,String>bookingDatesMap=new HashMap<>();
        bookingDatesMap.put("checkin",checkin);
        bookingDatesMap.put("checkout",checkout);
        return bookingDatesMap;

    }
    public Map<String,Object>expectedDataSetUp(String firstname,String lastname,int totalprice,Boolean depositpaid,Map<String,String>bookingdates){
        Map<String,Object>expectedMap=new HashMap<>();
        expectedMap.put("firstname",firstname);
        expectedMap.put("lastname",lastname);
        expectedMap.put("totalprice",totalprice);
        expectedMap.put("depositpaid",depositpaid);
        expectedMap.put("bookingdates",bookingdates);
        return expectedMap;

    }

}
