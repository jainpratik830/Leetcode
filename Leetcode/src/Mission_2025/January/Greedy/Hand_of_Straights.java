package Mission_2025.January.Greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Hand_of_Straights {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length%groupSize!=0){
            return false;
        }

        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int i:hand){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        int groupCount = hand.length/groupSize;
        int count =0;

        while (count<groupCount && !map.isEmpty()){
            int curr = map.firstKey();
            int n = 1;
            if (map.get(curr)-1==0){
                map.remove(curr);
            }else {
                map.put(curr,map.get(curr)-1);
            }
            while (map.containsKey(curr+1) && n<groupSize){
                curr++;
                if (map.get(curr)-1==0){
                    map.remove(curr);
                }else {
                    map.put(curr,map.get(curr)-1);
                }
                n++;
            }
            if (n==groupSize){
                count++;
            }else {
                return false;
            }
        }

        return count==groupCount;
    }

}
