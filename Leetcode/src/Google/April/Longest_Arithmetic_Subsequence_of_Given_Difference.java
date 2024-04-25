package Google.April;

import java.util.HashMap;
import java.util.Map;

public class Longest_Arithmetic_Subsequence_of_Given_Difference {

    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer,Integer> map = new HashMap<>();
        int ans = 1;
        map.put(arr[0],1);
        for (int i=1;i<arr.length;i++){
            if (map.containsKey(arr[i]-difference)){
                map.put(arr[i],map.get(arr[i]-difference)+1);
                ans = Math.max(ans,map.get(arr[i]));
            }else{
                map.put(arr[i],1);
            }
        }
        return ans;
    }


}
