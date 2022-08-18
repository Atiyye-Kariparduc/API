package GetRequest;

import BaseURL.BaseURLNew;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetNew07 extends BaseURLNew {
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
    public void getnew07(){
    spec.pathParam("pp1","todos");
    Response response=given().spec(spec).when().get("{pp1}");
    response.then().assertThat().statusCode(200);
    JsonPath json=response.jsonPath();
    List<Integer>idlist=json.getList("findAll{it.id>190}.id");
    Assert.assertEquals(10,idlist.size());
   // Assert.assertTrue(idlist.size()==10);
JsonPath json2=response.jsonPath();
List<Integer>userIdList=json2.getList("findAll{it.id<5}.userId");
Assert.assertEquals(4,userIdList.size());

//JsonPath json3=response.jsonPath();
//List<String>ListTitle=json3.getList("findAll{it.id<5}.title");
//Assert.assertTrue(ListTitle.contains("delectus aut autem"));
//response.then().assertThat().body("title",hasItem("delectus aut autem"));
//Assert.assertEquals("delectus aut autem","title");


}

}
