package Google.April;

import java.util.Arrays;

public class Target_Sum {

    Integer[][] dp;
    int total;
    public int recursion(int[] nums,int i,int curr,int target){

        if (i==nums.length && target==curr){
            return  1;
        }

        if (i== nums.length && target!=curr){
            return 0;
        }

        if (dp[i][total + curr]!=null){
            return dp[i][total +curr];
        }

        return dp[i][total +curr]=recursion(nums,i+1,curr+nums[i],target)+recursion(nums,i+1,curr-nums[i],target);

    }

    public int findTargetSumWays(int[] nums, int target) {
        total = Arrays.stream(nums).sum();
        dp =  new Integer[nums.length+1][2*total+1];
        return recursion(nums,0,0,target);

    }

}
