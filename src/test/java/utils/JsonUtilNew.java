package utils;


import org.codehaus.jackson.map.ObjectMapper;
import pojo.JsonPlaceHolderPojo;
import pojo.pojoNew01;

import java.io.IOException;

public class JsonUtilNew {


    //pojoNew01 obj=new pojoNew01(15,"ayse",true);


     private static ObjectMapper mapper;

    static{
        mapper=new ObjectMapper();

    }

    //Json to Java

    public static <T> T  convertJsonToJava(String json,Class<T>cls){
       T javaResult=null;

        try {
            javaResult=mapper.readValue(json,cls);
        } catch (IOException e) {
            System.out.println("could not convert"+e.getMessage());


        }
        return javaResult;

    }

    public static  String convertJavatoJson(Object obj){
        String JsonResult=null;


        try {
            JsonResult=mapper.writeValueAsString(obj);
        } catch (IOException e) {
            System.out.println("can not convert"+e.getMessage());
        }
         return JsonResult;
    }

}
