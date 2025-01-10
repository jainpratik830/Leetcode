package Mission_2025.January.DP;

public class Best_Time_to_Buy_and_Sell_Stock {

    public int maxProfit(int[] prices) {
        int ans =0;

        int minSoFar = prices[0];
        for (int i:prices){
            ans = Math.max(ans,i-minSoFar);
            minSoFar = Math.min(i,minSoFar);
        }
        return ans;
    }

}
