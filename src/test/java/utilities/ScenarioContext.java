package utilities;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

    private static Map<String, Object> dataMap = new HashMap<>();

    public static void put(String key, Object value){
        dataMap.put(key, value);
    }

    public static Object get(String key){
        if(dataMap.containsKey(key)){
            return dataMap.get(key);
        }
        else return null;
    }
}
