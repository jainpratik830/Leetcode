package Google.April;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendar {

    TreeMap<Integer,Integer> map;
    public MyCalendar() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Map.Entry<Integer,Integer> entry = map.floorEntry(start);
        Map.Entry<Integer,Integer> entryCeil = map.ceilingEntry(start);
        if (entry==null && entryCeil==null){
            map.put(start,end);
            return true;
        }
        else if (entry!=null && entryCeil!=null){
            int endLast = entry.getValue();
            int startNext = entryCeil.getKey();
            if (end<=startNext && endLast<=start){
                map.put(start,end);
                return true;
            }
        }
        else if (entry!=null){
            int endLast = entry.getValue();
            if (endLast<=start){
                map.put(start,end);
                return true;
            }
        }else {
            int startNext = entryCeil.getKey();
            if (end<=startNext){
                map.put(start,end);
                return true;
            }
        }
        return false;
    }
}
