package patch_request;

import BaseURL.BaseURLNew;
import org.junit.Test;
import test_data.JsonDataType;

import java.util.Map;

public class Patch01 extends BaseURLNew {
    /*
     Given
	        1) https://jsonplaceholder.typicode.com/todos/198
	        2) {
                 "title": "Wash the dishes"
               }
        When
	 		I send PATCH Request to the Url
	    Then
	   	   Status code is 200
	   	   And response body is like   {
									    "userId": 10,
									    "title": "Wash the dishes",
									    "completed": true,
									    "id": 198
									   }
     */
    @Test
    public void patch01(){
        spec.pathParams("pp1","todos","pp2",198);
        JsonDataType obj=new JsonDataType();
       Map<String,Object>expectedData= obj.getExpectedDatawith(null,"Wash the dishes",null);
        System.out.println(expectedData);

    }
}
