package Mission_2025.January.Binary_Search;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Time_Based_Key_Value_Store {

    class TimeMap {

        HashMap<String, TreeMap<Integer,String>> map;

        public TimeMap(){
            map = new HashMap<>();
        }

        public void set(String key,String value,int timestamp){
            map.putIfAbsent(key,new TreeMap<>());
            map.get(key).put(timestamp,value);
        }

        public String get(String key,int timestamp){

            if (map.containsKey(key)){
               Map.Entry<Integer,String> entry=  map.get(key).floorEntry(timestamp);
               if (entry!=null){
                   return entry.getValue();
               }
            }
            return "";
        }

    }

}
