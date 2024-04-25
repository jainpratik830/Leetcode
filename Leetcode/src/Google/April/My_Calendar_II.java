package Google.April;

import java.util.Map;
import java.util.TreeMap;

public class My_Calendar_II {

    class MyCalendarTwo {

        Map<Integer,Integer> map;

        public MyCalendarTwo() {
            map =new TreeMap<>();
        }

        public boolean book(int start, int end) {
            map.put(start,map.getOrDefault(start,0)+1);
            map.put(end,map.getOrDefault(end,0)-1);
            int sum  = 0;
            for (int value: map.values()){
                sum += value;
                if (sum>=3){
                    map.put(start,map.getOrDefault(start,0)-1);
                    map.put(end,map.getOrDefault(end,0)+1);
//                    if(map.get(start) == 0)
//                        map.remove(start);
                    return false;
                }
            }

            return true;
        }
    }

}
