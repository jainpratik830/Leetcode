package Mission_2025.January.Greedy;

import java.util.Arrays;

public class Jump_Game_II {


    public int jump(int[] nums) {
        int n = nums.length;
        int farthest = 0;
        int currEnd  =0;
        int steps =0;
        for (int i=0;i<n-1;i++){

            farthest = Math.max(farthest,i+nums[i]);
            if (i==currEnd){
                steps++;
                currEnd =farthest;
            }
        }
        return steps;
    }

    public int jump2(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,nums.length+1);
        dp[nums.length-1]=0;

        for (int i= nums.length-2;i>=0;i--) {
            for (int j = 1; j <= Math.min(nums.length - 1-i, nums[i]); j++){
                dp[i] = Math.min(dp[i+j]+1,dp[i]);

            }
        }
        return dp[0];
    }

}
