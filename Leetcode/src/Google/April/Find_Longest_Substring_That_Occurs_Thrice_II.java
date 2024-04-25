package Google.April;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Find_Longest_Substring_That_Occurs_Thrice_II {


    public boolean isPossible(String s,HashMap<Character, List<Integer>> map,int mid){
        for (char k:map.keySet()){
            int count =0;
            for (int value:map.getOrDefault(k,new ArrayList<>())){
                count += Math.max(0,value-mid+1);



            }
            if (count>=3){
                return true;
            }

        }
        return false;
    }

    public int maximumLength(String s) {
        int ans = -1;
        HashMap<Character, List<Integer>> map = new HashMap<>();
        if (s.length()<=2){
            return -1;
        }

        char curr = s.charAt(0);
        int count =1;

        for (int i=1;i<s.length();i++){
            if (s.charAt(i)==curr){
                count++;
            }else {
                map.putIfAbsent(curr,new ArrayList<>());
                map.get(curr).add(count);
                count=1;
                curr= s.charAt(i);
            }
        }
        map.putIfAbsent(curr,new ArrayList<>());
        map.get(curr).add(count);
        // System.out.println(map);
        int low = 0;
        int high = s.length()-2;

        while (low<=high){
            int mid = (low+high)/2;
            // System.out.println(low);
            boolean isPossible = isPossible(s,map,mid);
            if (isPossible){
                ans = mid;
                low = mid+1;
            }else {
                high=mid-1;
            }

        }

        return ans==0 ? -1 : ans;
    }


}
