package test_data;

import java.util.HashMap;
import java.util.Map;

public class JsonDataType {
    public static void main(String[] args) {
    }

    public Map<String, Object> getExpectedData(Integer userId, String title, Boolean completed) {
        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("userId", 1);


        expectedData.put("title", "quis ut nam facilis et officia qui");
        expectedData.put("completed", false);

return expectedData;
    }

    public Map<String, Object> getExpectedDatawith(Integer userId, String title, Boolean completed) {
        Map<String, Object> expectedData = new HashMap<>();

if(userId!=null){
    expectedData.put("userId",userId);
}

        expectedData.put("title", "quis ut nam facilis et officia qui");
if(completed!=null){
    expectedData.put("completed",completed);
}
        return expectedData;
    }
}








      /*  expectedData.put("Status code",200);
        expectedData.put("Via","1.1 vegur");
        expectedData.put("Server","cloudflare");*/


