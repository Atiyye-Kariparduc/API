package GetRequest;

import BaseURL.gorest_url;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.Assert;
import test_data.gorestTest;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

/*
        Given
            https://gorest.co.in/public/v1/users/13
        When
            User send GET Request to the URL
        Then
            Status Code should be 200
        And
            Response body should be like
       {
        "meta": null,
    "data": {
        "id": 13,
        "name": "Dandak Adiga",
        "email": "adiga_dandak@christiansen-schimmel.biz",
        "gender": "female",
        "status": "active"
    }
}
          }
        }
     */


public class Get10 extends gorest_url {
    @Test
    public void get10() {
        spec.pathParams("pp1", "users", "pp2", 13);
        gorestTest expected = new gorestTest();
        Map<String, String> dataMap = expected.expectedinner("Dandak Adiga", "adiga_dandak@christiansen-schimmel.biz", "female", "active");
        Map<String, Object> expectedouter = expected.expectedouter(null, dataMap);
        System.out.println(dataMap);
        System.out.println(expectedouter);
        Response response = given().spec(spec).contentType(ContentType.JSON).when().get("{pp1}/{pp2}");
        response.then().statusCode(200);
        Map<String, Object> actualData = response.as(HashMap.class);
        Assert.assertEquals(actualData.get("meta"), expectedouter.get("meta"));

       // Assert.assertEquals(dataMap.get("name"), ((Map) actualData.get("data")).get("name"));
        //Assert.assertEquals(dataMap.get("name"), ((Map) actualData.get("data")).get("name"));


    }

}
