package Google.May.Neetcode150;

import java.util.HashMap;
import java.util.TreeMap;

public class TimeMap {

    HashMap<String, TreeMap<Integer,String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key,new TreeMap<>());
        map.get(key).put(timestamp,value);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer,String> curr = map.get(key);
        if (curr == null) {
            return "";
        }

        return curr.floorEntry(timestamp) !=null ? curr.floorEntry(timestamp).getValue(): "";
    }

}
