package test_data;

import java.util.HashMap;
import java.util.Map;

public class JsonNewData {
    /*
     "userId": 1,
                "id": 2,
                "title": "quis ut nam facilis et officia qui",
                "completed": false
     */
    public Map<String, Object> expectedData(Integer userId, String title, Boolean completed, String Via, String Server) {
        Map<String, Object> expectedMap = new HashMap<>();


        expectedMap.put("title", title);

        if (Via != null) {
            expectedMap.put("Via", Via);
        }
        if (Server != null) {
            expectedMap.put("Server", Server);
        }

        if (userId != null) {
            expectedMap.put("userId", userId);
        }
        if (completed != null) {
            expectedMap.put("completed", completed);
        }
        return expectedMap;

    }

    public String expectedDataInString(Integer userId, String title, Boolean completed) {
        /*
        {
									    "userId": userId,
									    "title": title,
									    "completed": completed
									  }
     */

        String expectedData = "{\n" +
                "\t\t\t\t\t\t\t\t\t    \"userId\": userId,\n" +
                "\t\t\t\t\t\t\t\t\t    \"title\": title,\n" +
                "\t\t\t\t\t\t\t\t\t    \"completed\": completed\n" +
                "\t\t\t\t\t\t\t\t\t  }";
return expectedData;

    }

}
