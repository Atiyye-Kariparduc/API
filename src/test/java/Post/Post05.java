package Post;

import BaseURL.DummyRestApiBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojo.BookingResponseBodyPojo;
import pojo.Data;
import pojo.DummyRestPojo;
import utils.JsonUtilNew;

import static io.restassured.RestAssured.given;

public class Post05 extends DummyRestApiBaseUrl {

    /*
       URL: https://dummy.restapiexample.com/api/v1/create
       HTTP Request Method: POST Request
       Request body: {
                        "employee_name": "Tom Hanks",
                        "employee_salary": 111111,
                        "employee_age": 23,
                        "profile_image": "Perfect image"
                     }
       Test Case: Type by using Gherkin Language
       Assert:
                i) Status code is 200
                ii) Response body should be like the following
                    {
                        "status": "success",
                        "data": {
                            "employee_name": "Ali Can",
                            "employee_salary": 111111,
                            "employee_age": 23,
                            "profile_image": "Perfect image",
                            "id": 6344
                        },
                        "message": "Successfully! Record has been added."
                    }
     */
@Test
    public void put05(){
    spec.pathParam("pp1","create");
    Data expectedInner=new Data(6344,"Ali Can",11111,23,"Perfect image");
    DummyRestPojo expectedData=new DummyRestPojo("success",expectedInner,"Successfully! Record has been added.");

    Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("{pp1}");

    DummyRestPojo actualData=JsonUtilNew.convertJsonToJava(response.asString(),DummyRestPojo.class);
    Assert.assertEquals(200,response.getStatusCode());
    Assert.assertEquals(expectedData.getStatus(),actualData.getStatus());
    Assert.assertEquals(expectedInner.getEmployeeName(),actualData.getData().getEmployeeName());
    Assert.assertEquals(expectedInner.getEmployeeAge(),actualData.getData().getEmployeeAge());
    Assert.assertEquals(expectedInner.getEmployeeSalary(),actualData.getData().getEmployeeSalary());
    Assert.assertEquals(expectedInner.getProfileImage(),actualData.getData().getProfileImage());
    Assert.assertEquals(expectedInner.getId(),actualData.getData().getId());
    Assert.assertEquals(expectedData.getMessage(),actualData.getMessage());




}
}
