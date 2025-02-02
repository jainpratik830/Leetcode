package Mission_2025.February.DP;

import java.util.Arrays;
import java.util.Map;

public class Number_of_Longest_Increasing_Subsequence {

    public int findNumberOfLIS(int[] nums) {
        int[] dp= new int[nums.length];
        int[] count = new int[nums.length];
        Arrays.fill(dp,1);
        int max =1;
        count[0]=1;
        for (int i=1;i<nums.length;i++){

            for (int j=0;j<i;j++){
                if (nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            if (dp[i]>max){
                max= dp[i];
            }
            if (dp[i]==1){
                count[i]=1;
            }else {
                for (int j=0;j<i;j++){
                    if (nums[i]>nums[j] && dp[i]==dp[j]+1){
                        count[i] += count[j];
                    }
                }
            }

        }
        int ans =0;
        for (int i=0;i<nums.length;i++){
            if (dp[i]==max){
                ans+= count[i];
            }
        }
        return ans;

    }

}
