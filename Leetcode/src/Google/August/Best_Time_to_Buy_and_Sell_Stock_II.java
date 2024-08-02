package Google.August;

import java.util.Arrays;

public class Best_Time_to_Buy_and_Sell_Stock_II {

    public int helper(int[] prices,int i,int state,int[][] dp){

        if (i==prices.length){
            return 0;
        }

        if (dp[i][state]!=-1){
            return dp[i][state];
        }
        int profitCurr =0;
        if (state==1){
             profitCurr=Math.max(helper(prices,i+1,0,dp)+prices[i],helper(prices,i+1,1,dp));
        }else {
             profitCurr=Math.max(helper(prices,i+1,1,dp)-prices[i],helper(prices,i+1,0,dp));
        }

        return dp[i][state]=profitCurr;

    }

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int[] x : dp) {
            Arrays.fill(x, -1);
        }
        return helper(prices,0,0,dp);
    }

}
