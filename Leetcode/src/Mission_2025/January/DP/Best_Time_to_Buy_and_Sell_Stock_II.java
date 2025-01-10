package Mission_2025.January.DP;

import java.util.Arrays;

public class Best_Time_to_Buy_and_Sell_Stock_II {

    public int helper(int[] prices,int i,int state,int[][] dp){
        if (i==prices.length){
            return 0;
        }

        if (dp[i][state]!=-1){
            return dp[i][state];
        }

        int prof= 0;
        if (state==1){
            prof= Math.max(helper(prices,i+1,1,dp),prices[i]+helper(prices,i+1,0,dp));
        }else {
            prof= Math.max(helper(prices,i+1,0,dp),-prices[i]+helper(prices,i+1,1,dp));
        }

        return dp[i][state]=prof;
    }

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int[] x : dp) {
            Arrays.fill(x, -1);
        }
        return helper(prices,0,0,dp);
    }

    public int maxProfit2(int[] prices) {
        int curr = prices[0];
        int ans =0;
        for (int i=0;i<prices.length;i++) {
            ans += Math.max(0,prices[i]-curr);
            curr= prices[i];
        }
        return ans;
    }
}
