package Google.August;

import java.util.Arrays;

public class Best_Time_Buy_Sell_Stock_Transaction_Fee {

    int fee;

    public int helper(int[] prices,int i,int state,int[][] dp){

        if (i==prices.length){
            return 0;
        }

        if (dp[i][state]!=-1){
            return dp[i][state];
        }
        int profitCurr =0;
        if (state==1){
            profitCurr=Math.max(helper(prices,i+1,0,dp)+prices[i]-fee,helper(prices,i+1,1,dp));
        }else {
            profitCurr=Math.max(helper(prices,i+1,1,dp)-prices[i],helper(prices,i+1,0,dp));
        }

        return dp[i][state]=profitCurr;

    }

    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        this.fee= fee;
        for (int[] x : dp) {
            Arrays.fill(x, -1);
        }
//        return helper(prices,0,0,dp);


        int[] prev = new int[2];
        int n=prices.length;
        for(int index=n-1;index>=0;index--){
            int[] current=new int[2];
            current[1]= Math.max(-prices[index]+prev[0],prev[1]);
            current[0]= Math.max(prices[index]-fee+prev[1],prev[0]);
            prev=current;
        }
        return prev[1];
    }

}
