package Mission_2025.January.DP;

import java.util.Arrays;

public class Best_Time_to_Buy_and_Sell_Stock_III {


    public int helper(int[] prices,int i,int state,int count,int[][][] dp){

        if (i==prices.length || count==2){
            return 0;
        }

        if (dp[i][state][count]!=-1){
            return dp[i][state][count];
        }

        int cur = 0;
        if (state==1){
            cur =Math.max(prices[i]+helper(prices,i+1,0,count+1,dp),helper(prices, i+1, state, count, dp));
        }else {
            cur =Math.max(-prices[i]+helper(prices,i+1,1,count,dp),helper(prices, i+1, state, count, dp));
        }

        return dp[i][state][count]=cur;

    }

    public int maxProfit2(int[] prices) {
        int[][][] dp = new int[prices.length][2][2];

        for (int[][] i:dp){
            for (int[] j:i){
                Arrays.fill(j,-1);
            }
        }

        return helper(prices,0,0,0,dp);
    }


    public int maxProfit(int[] prices) {

        int[] left= new int[prices.length];
        int minSoFar = prices[0];

        int[] right= new int[prices.length];
        int maxSoFar = prices[prices.length-1];
        for (int i=0;i<prices.length;i++){
            if (i>0)
                left[i] = Math.max(left[i-1],prices[i]-minSoFar);
            minSoFar = Math.min(prices[i],minSoFar);
        }

        for (int i=prices.length-1;i>=0;i--){
            if (i<prices.length-1)
                 right[i] = Math.max(right[i+1],maxSoFar- prices[i]);
            maxSoFar = Math.max(prices[i],maxSoFar);
        }

        int ans =0;
        for (int i=0;i<prices.length;i++){
            ans = Math.max(ans,left[i]+right[i]);
        }
        return ans;
    }


}
