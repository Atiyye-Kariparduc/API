package GetRequest;

import BaseURL.gorest_url;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import static org.hamcrest.Matchers.*;
import org.testng.Assert;

import java.util.List;

import static io.restassured.RestAssured.given;

/*
        Given
            https://gorest.co.in/public/v1/users
        When
            User send GET Request
        Then
            The value of "pagination limit" is 10
        And
            The "current link" should be "https://gorest.co.in/public/v1/users?page=1"
        And
            The number of users should  be 10
        And
            We have at least one "active" status
        And
            "Shashi Sethi", "Dr. Chandravati Pothuvaal, "Deepesh Nambeesan" are among the users
        And
            The female users are more than male users
     */
public class Get11 extends gorest_url {
    @Test
    public void get11(){
        spec.pathParam("pp1","users");
        Response response=given().spec(spec).when().get("{pp1}");

        response.then().assertThat().statusCode(200).body("meta.pagination.limit",equalTo(10),
                "meta.links.current",equalTo("https://gorest.co.in/public/v1/users?page=1"),
                "data.id",hasSize(10),"data.status",hasItem("active"),"data.name",hasItems("Dr. Chandravati Pothuvaal","Deepesh Nambeesan"));

        JsonPath json=response.jsonPath();
        List<String>genders=json.getList("data.gender");

       // List<Integer> femalesize =json.getList("findAll{it."female"}.gender");
        int counter=0;
        for(String w:genders){
            if(w.equals("female")){
                counter++;
            }
        }
        System.out.println(counter+"numberoffemales");
        int male=genders.size()-counter;
        Assert.assertTrue(counter>=male);



    }
}
