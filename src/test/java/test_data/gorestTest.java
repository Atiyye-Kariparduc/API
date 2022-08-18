package test_data;

import java.util.HashMap;
import java.util.Map;

public class gorestTest {
    public Map<String, String> expectedinner( String name, String email,String gender,String status) {
        Map<String, String> DataMap = new HashMap<>();
        DataMap.put("name", name);
        DataMap.put("email", email);
        DataMap.put("gender", gender);
        DataMap.put("status", status);
        return DataMap;
    }
        public Map<String,Object> expectedouter(Object meta,Map data){
Map<String,Object>expectedDataMap=new HashMap<>();
expectedDataMap.put("meta",meta);
expectedDataMap.put("data",data);
return expectedDataMap;


        }
    }





