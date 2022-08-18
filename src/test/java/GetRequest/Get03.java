package GetRequest;

import BaseURL.BaseUrls;
import org.junit.Test;

import static io.restassured.RestAssured.given;
/*
        Given
            https://jsonplaceholder.typicode.com/todos/23
        When
            User send GET Request to the URL
        Then
            HTTP Status Code should be 200
		And
		    Response format should be “application/json”
		And
		    “title” is “et itaque necessitatibus maxime molestiae qui quas velit”,
		And
		    “completed” is false
		And
		    “userId” is 2

 */

public class Get03 extends BaseUrls {
    @Test

public void get01(){



    }
}

