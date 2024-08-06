package Google.August;

import java.util.Arrays;

public class Target_Sum {

    Integer[][] dp;
    int total;

    public int recurse(int[] nums,int index,int curr,int target){

        if (index==nums.length && curr==target){
            return 1;
        }

        if (index>=nums.length){
            return 0;
        }

        if (dp[index][curr+total]!=null){
            return dp[index][curr+total];
        }

        return recurse(nums,index+1,curr+nums[index],target)+recurse(nums,index+1,curr-nums[index],target);

    }

    public int findTargetSumWays(int[] nums, int target) {
         total = Arrays.stream(nums).sum();
        dp = new Integer[nums.length][total*2+1];

        return recurse(nums,0,0,target);
    }

}
