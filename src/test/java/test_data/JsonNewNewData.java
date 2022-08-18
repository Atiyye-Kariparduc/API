package test_data;

import java.util.Map;

public class JsonNewNewData {
    /*
    {
									    "userId": "userId",
									    "title": "title",
									    "completed": "completed"
									  }
     */
    public String jsonString(Integer userId, String title, Boolean completed){

        String str= "{\n" +
                "        \"userId\": "+userId+", \n" +
                "        \"title\": \""+title+"\",\n" +
                "        \"completed\":"+completed+"\n" +
                "        }";

        
        return str;
    }
}
