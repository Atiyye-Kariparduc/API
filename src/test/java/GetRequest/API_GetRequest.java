package GetRequest;

import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.given;
public class API_GetRequest {
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
    @Test
    public void get01() {

        String url = " https://restful-booker.herokuapp.com/booking/101";
        Response response = given().when().get(url);
       // response.prettyPrint();
        response.then().assertThat().statusCode(200).contentType("application/json").statusLine("HTTP/1.1 200 OK");
        //System.out.println(response.getStatusCode());
       // System.out.println(response.getHeader("User-Agent"));
        System.out.println(response.getTime());
    }
}
