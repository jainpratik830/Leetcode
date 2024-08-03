package Google.August;

import java.util.HashMap;

public class Arithmetic_Slices_II_Subsequence {

    public int numberOfArithmeticSlices(int[] nums) {
        int ans =0;
        int n = nums.length;
        HashMap<Long,Integer>[] dp = new HashMap[n];

        for (int i=0;i<n;i++){
            dp[i]=new HashMap<>();
        }

        for (int i=0;i<nums.length;i++){

            for (int j=0;j<i;j++){
                long diff=(long) nums[i]-nums[j];
                dp[i].put(diff, dp[i].getOrDefault(diff,0)+ dp[j].getOrDefault(diff,0)+1);
                ans += dp[j].getOrDefault(diff,0);
            }

        }

        return ans;
    }

}
