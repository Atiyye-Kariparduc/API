package GetRequest;
/*

    Given
               https://restful-booker.herokuapp.com/booking/101
           When
               User sends a GET Request to the url
           Then
               HTTP Status Code should be 200
           And
               Content Type should be JSON
           And
               Status Line should be HTTP/1.1 200 OK

    */

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class GetNew01 {

@Test
    public void getnew01(){

    String url=" https://restful-booker.herokuapp.com/booking/101";

    JSONObject expectedData=new JSONObject();
    expectedData.put("Status Code",200);
    expectedData.put("Content Type","JSON");
    expectedData.put("Status Line","HTTP/1.1 200 OK");


    Response response=given().when().get(url);
     //response.prettyPrint();

    response.then().assertThat().
            statusCode(200).
            contentType(ContentType.JSON).
            statusLine("HTTP/1.1 200 OK");



}

}
