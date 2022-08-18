package GetRequest;

import BaseURL.DummyRestApiBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Get16ObjectMapper extends DummyRestApiBaseUrl {
    @Test
    public void get01(){
        /*

 URL: https://dummy.restapiexample.com/api/v1/employees
           HTTP Request Method: GET Request
           Test Case: Type by using Gherkin Language
           Assert:  i) Status code is 200
                   ii) There are 24 employees
                  iii) "Tiger Nixon" and "Garrett Winters" are among the employees
                   iv) The greatest age is 66
                    v) The name of the lowest age is "Tatyana Fitzpatrick"
                   vi) Total salary of all employees is 6,644,770

         */
        /*
          Given
        URL: https://dummy.restapiexample.com/api/v1/employees
          When
        HTTP Request Method: GET Request

           Then
         Status code is 200
           And
         There are 24 employees
           And
         "Tiger Nixon" and "Garrett Winters" are among the employees
           And
          The greatest age is 66
           And
          The name of the lowest age is "Tatyana Fitzpatrick"
           And
          Total salary of all employees is 6,644,770
         */

        spec.pathParam("pp1","employees");

        Response response=given().spec(spec).when().get("{pp1}");
       // response.then().assertThat().statusCode(200).body("data.id",hasSize(24),"data.employee_name",hasItems("Tiger Nixon","Garrett Winters"));
        JsonPath json=response.jsonPath();
        List<Integer> list=json.getList("data.findAll{it.employee_age}.employee_age");
        Collections.sort(list);
        System.out.println(list.get(list.size()-1));

      /*  JsonPath Json = response.jsonPath();
        List<Integer> age = Json.getList("data.employee_age");
        System.out.println(age);
        age.sort(Comparator.comparing(Integer::intValue));
        System.out.println(age);
        System.out.println(age.get(age.size()-1));
        */
        //Assert.assertEquals(66,(int)list.get(list.size()-1));
        System.out.println(list.get(0));
        String nameOflowestAge=json.getString("data.findAll{it.employee_age=="+list.get(0)+"}.employee_age");
        System.out.println(nameOflowestAge);
        //Assert.assertEquals("Tatyana Fitzpatrick",nameOflowestAge);

        List<Integer>salary=json.get("data.findAll{it.id}.employee_salary");
        int total=0;
        for(Integer w:salary){
            total=total+w;

        }
        System.out.println(total+"total");
int sum2=salary.stream().reduce(0,(t,u)->(t+u));
int sum3=salary.stream().reduce(0,Math::addExact);
    }

}
