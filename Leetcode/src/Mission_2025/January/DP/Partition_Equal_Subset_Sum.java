package Mission_2025.January.DP;

import java.util.Arrays;

public class Partition_Equal_Subset_Sum {
    Boolean[][] dp;
    public boolean helper(int i,int[] nums,int sum,int target){

        if (sum==target){
            return true;
        }

        if (i>=nums.length || sum>target){
            return false;
        }


        if (dp[i][sum]!=null){
            return dp[i][sum];
        }

        boolean possible = helper(i+1,nums,sum,target);

        possible = possible || helper(i+1,nums,sum+nums[i],target);

        return dp[i][sum]= possible;

    }

    public boolean canPartition(int[] nums) {

        int sum = Arrays.stream(nums).sum();
        dp = new Boolean[nums.length][sum/2+1];
        if (sum%2!=0){
            return false;
        }

        return helper(0,nums,0,sum/2);

    }

}
