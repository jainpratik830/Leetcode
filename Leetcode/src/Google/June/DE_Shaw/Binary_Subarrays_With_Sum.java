package Google.June.DE_Shaw;

import java.util.HashMap;

public class Binary_Subarrays_With_Sum {

    public int numSubarraysWithSum(int[] nums, int goal) {
        int ans =0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int curr = 0;
        for (int i:nums){
            curr += i;
            if (map.containsKey(curr-goal)){
                ans+=map.get(curr-goal);
            }
            map.put(curr,map.getOrDefault(curr,0)+1);
        }

        return ans;
    }

}
