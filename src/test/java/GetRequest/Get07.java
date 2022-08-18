package GetRequest;

import BaseURL.BaseURLNew;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.Assert;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Get07 extends BaseURLNew {

    /*
    Given
	   	    https://jsonplaceholder.typicode.com/todos
		When
			 I send GET Request to the URL
		Then
			 1)Status code is 200
			 2)Print all ids greater than 190 on the console
			   Assert that there are 10 ids greater than 190
			 3)Print all userIds whose ids are less than 5 on the console
			   Assert that the number of userIds whose ids are less than 5 is 4
			 4)Print all titles whose ids are less than 5
			   Assert that "delectus aut autem" is one of the titles whose id is less than 5
     */

    @Test
    public void get07(){
spec.pathParam("pp1","todos");
        Response response=given().spec(spec).when().get("{pp1}");
        Assert.assertEquals(response.getStatusCode(),200);

        JsonPath json=response.jsonPath();
        List<Integer>ids =json.getList("findAll{it.id>190}.id");
        System.out.println(ids);

Assert.assertEquals(10,ids.size());
List<Integer>id2=json.getList("findAll{it.id<5}.userId");
        System.out.println(id2);
        Assert.assertEquals(4,id2.size());
        List<String>title=json.getList("findAll{it.id<5.title");
        Assert.assertTrue(title.contains("delectus aut autem"));
Assert.assertTrue(title.stream().anyMatch(t->equals("delectus aut autem")));

    }
}
