package Google.May.CodingRound;

import java.util.Arrays;

public class Jump_Game_II {

    public int jump(int[] nums) {
        int[] dp = new int[nums.length+1];

        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for (int i=0;i<nums.length;i++){
            int curr = nums[i]+1;
            for (int j=i+1;j<=nums.length && j<=i+curr;j++){
                dp[j]= Math.min(dp[i]+1,dp[j]);
            }
        }
        // System.out.println(Arrays.toString(dp));
        return dp[nums.length];
    }


    public int jump2(int[] nums) {
        int ans =0;
        int maxSofar = 0;
        int currEnd = 0;

        for (int i=0;i<nums.length-1;i++){
             maxSofar = Math.max(maxSofar,i+nums[i]);
                if (i==currEnd){
                    ans++;
                    currEnd= maxSofar;
                }

        }

        return ans;
    }

}
