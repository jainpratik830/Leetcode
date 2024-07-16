package Google.June.Daily;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Intersection_of_Two_Arrays_II {

    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i:nums1){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        for (int i:nums2){
            if (map.containsKey(i)){
                ans.add(i);
                int count = map.get(i)-1;
                if (count==0){
                    map.remove(i);
                }else {
                    map.put(i,count);
                }
            }
        }

        int[] resp=ans.stream().mapToInt(Integer::intValue)
                .toArray();
        return resp;
    }

}
