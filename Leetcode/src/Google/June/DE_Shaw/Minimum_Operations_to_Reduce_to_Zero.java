package Google.June.DE_Shaw;

import java.util.HashMap;

public class Minimum_Operations_to_Reduce_to_Zero {

    public int minOperations(int[] nums, int x) {
        int ans =-1;
        int sum = 0;
        for (int i:nums){
            sum+=i;
        }
        if(x==sum){
            return nums.length;
        }
        sum -= x;
        if (sum<0){
            return -1;
        }
        HashMap<Integer,Integer> zeroCount = new HashMap<>();
        zeroCount.put(0,-1);
        int curr =0;
        for (int i=0;i<nums.length;i++){
            curr += nums[i];
            if (zeroCount.containsKey(curr-sum)){
                // System.out.println(zeroCount);
                // System.out.println(curr);
                // System.out.println(sum);
                ans = Math.max(ans,i-zeroCount.get(curr-sum));
            }
            // }if (!zeroCount.containsKey(curr)){
            zeroCount.put(curr,i);
            // }

        }

        return ans != -1 ? nums.length-ans : ans;
    }

}
