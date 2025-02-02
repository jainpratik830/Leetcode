package Mission_2025.February.DP;

import java.util.Arrays;
import java.util.HashMap;

public class Delete_and_Earn {

    public int helper(int[] nums,int index,int[] dp){
        if (index== nums.length){
            return 0;
        }

        if (dp[index]==0){
            int curr = nums[index];
            int skip = index+1;

            while (skip<nums.length && nums[skip]==nums[index]){
                curr+= nums[index];
                skip++;
            }

            while (skip<nums.length && nums[skip]==nums[index]+1){
                skip++;
            }

            curr += helper(nums,skip,dp);
            int notSelect = helper(nums,index+1,dp);

            return dp[index]=Math.max(curr,notSelect);
        }

        return dp[index];
    }

    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        return helper(nums,0,new int[nums.length]);
    }

}
