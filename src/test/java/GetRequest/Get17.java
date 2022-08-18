package GetRequest;

import BaseURL.DummyRestApiBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.Assert;
import pojo.Data;
import pojo.DummyRestPojo;
import utils.JsonUtilNew;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Get17 extends DummyRestApiBaseUrl {
    /*
    Given
      URL: https://dummy.restapiexample.com/api/v1/employee/1
    When
       HTTP Request Method: GET Request
    Then
        Status code is 200
    And
        "employee_name" is "Tiger Nixon"
    And
        "employee_salary" is 320800
    And
        "employee_age" is 61
    And
        "status" is "success"
    And
         "message" is "Successfully! Record has been fetched."
     */


    @Test
    public void get01(){
spec.pathParams("pp1","employee","pp2",1);
        Data dataPojo=new Data(1,"Tiger Nixon",320800,61,"");
        DummyRestPojo expectedData=new DummyRestPojo("success",dataPojo,"Successfully! Record has been fetched.");

        Response response=given().spec(spec).when().get("{pp1},{pp2}");
        DummyRestPojo actualData  =JsonUtilNew.convertJsonToJava(response.asString(),DummyRestPojo.class);



        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(actualData.getData().getEmployeeName(),expectedData.getData().getEmployeeName());
        Assert.assertEquals(actualData.getData().getEmployeeSalary(),expectedData.getData().getEmployeeSalary());
        Assert.assertEquals(actualData.getData().getEmployeeAge(),expectedData.getData().getEmployeeAge());
        Assert.assertEquals(actualData.getStatus(),expectedData.getStatus());
        Assert.assertEquals(actualData.getMessage(),expectedData.getMessage());
//Assert.assertTrue(actualData.getStatus().equals("success"));
        

    }
}
