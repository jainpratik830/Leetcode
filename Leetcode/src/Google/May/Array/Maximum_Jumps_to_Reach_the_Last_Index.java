package Google.May.Array;

import java.util.Arrays;

public class Maximum_Jumps_to_Reach_the_Last_Index {

    public int maximumJumps(int[] nums, int target) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp,-1);

        dp[0]=0;
        for (int i=0;i<nums.length;i++){
            for (int j=0;j<i;j++){
                if (nums[i]-nums[j]<=target && nums[i]-nums[j]>=-1*target && dp[j]!=-1){
                    dp[i]= Math.max(dp[i],dp[j]+1);
                }
            }
        }
        return dp[nums.length-1];
    }

}
