package Google.September;

import java.util.HashMap;

public class Largest_Combination_With_Bitwise_AND_Greater_Than_Zero {

    public int largestCombination(int[] candidates) {
        int ans =0;
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i=0;i<31;i++){
            int curr =i;
            int count =0;
            for (int j=0;j<candidates.length;j++){
                if (((candidates[j] >> i ) & 1) > 0){
                    count++;
                }
            }
            map.put(curr,count);
        }

        for (int i:map.values()){
            ans = Math.max(ans,i);
        }
        return ans;
    }

}
