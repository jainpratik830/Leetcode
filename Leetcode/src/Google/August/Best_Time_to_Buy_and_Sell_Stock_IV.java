package Google.August;

import java.util.Arrays;

public class Best_Time_to_Buy_and_Sell_Stock_IV {

    public int helper(int[] prices,int i,int state,int[][][] dp,int count){

        if (count<=0){
            return 0;
        }

        if (i==prices.length){
            return 0;
        }

        if (dp[i][state][count]!=-1){
            return dp[i][state][count];
        }
        int profitCurr =0;
        if (state==1){
            profitCurr=Math.max(helper(prices,i+1,0,dp,count-1)+prices[i],helper(prices,i+1,1,dp,count));
        }else {
            profitCurr=Math.max(helper(prices,i+1,1,dp,count)-prices[i],helper(prices,i+1,0,dp,count));
        }

        return dp[i][state][count]=profitCurr;

    }

    public int maxProfit(int k,int[] prices) {
        int count =k;
        int[][][] dp = new int[prices.length][2][count+1];
        for (int[][] x : dp) {
            for (int[] a:x)
                Arrays.fill(a, -1);
        }
        return helper(prices,0,0,dp,count);
    }

}
