package Mission_2025.January.DP;

import java.util.Arrays;

public class Target_Sum {

    Integer[][] dp;
    int total;

    public int helper(int[] nums,int i,int curr,int target){

        if (i==nums.length && curr==target){
            return 1;
        }

        if (i==nums.length){
            return 0;
        }

        if (dp[i][total+curr]!=null){
            return dp[i][total+curr];
        }

        int pos = helper(nums,i+1,curr+nums[i],target);
        int neg = helper(nums,i+1,curr-nums[i],target);
        return dp[i][total+curr]= pos+neg;
    }

    public int findTargetSumWays(int[] nums, int target) {
        int sum= Arrays.stream(nums).sum();
        total=sum;
        dp= new Integer[nums.length][2*sum+1];

        return helper(nums,0,0,target);
    }

}
