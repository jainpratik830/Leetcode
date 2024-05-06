package Google.May.Others;

import java.util.HashMap;
import java.util.List;

public class Destination_City {

    public String destCity(List<List<String>> paths) {
        HashMap<String,Boolean> map = new HashMap<>();
        for(List<String> curr: paths){
            map.putIfAbsent(curr.get(0),false);
            map.putIfAbsent(curr.get(1),false);
            map.put(curr.get(0),true);
        }

        for (String key : map.keySet()){
            if(map.get(key)==false){
                return key;
            }
        }

        return "";
    }

}
