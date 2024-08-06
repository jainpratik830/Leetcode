package Google.August;

public class Number_of_Longest_Increasing_Subsequence {

    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        int longest = 0;
        for (int i=0;i<nums.length;i++){
            dp[i]=1;
            for (int j=0;j<i;j++){
                if (nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            // count[i]=1;
            longest = Math.max(longest,dp[i]);
            if(dp[i]==1){
                count[i]=1;
                continue;
            }
            for (int j=0;j<i;j++){
                if (dp[i]==dp[j]+1 && nums[i]>nums[j]){
                    count[i]+= count[j];
                }
            }

        }
        // System.out.println(Arrays.toString(dp));
        //  System.out.println(Arrays.toString(count));
        if(longest==1){
            return nums.length;
        }

        int ans =0;
        for (int i=0;i<dp.length;i++){
            if (dp[i]==longest){
                ans+= count[i];
            }
        }

        return ans;
    }

}
