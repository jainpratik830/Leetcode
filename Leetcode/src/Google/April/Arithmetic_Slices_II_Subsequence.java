package Google.April;

import java.util.HashMap;

public class Arithmetic_Slices_II_Subsequence {

    public int numberOfArithmeticSlices(int[] nums) {
        HashMap<Long,Integer>[] dp = new HashMap[nums.length];
        for(int i=0;i<nums.length;i++){
            dp[i]= new HashMap<>();
        }
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){

                long diff = (long) nums[i]-nums[j];
                int curr = dp[i].getOrDefault(diff,0);
                curr+= dp[j].getOrDefault(diff,0)+1;
                dp[i].put(diff,curr);


            }
        }

        int ans =0;
        for(int i=0;i<nums.length;i++){
            System.out.println(dp[i]);
            for(long k:dp[i].keySet()){
                ans+= dp[i].get(k);
            }
        }
        int n=nums.length;
        return (ans-((n*(n-1))/2));

    }

}
