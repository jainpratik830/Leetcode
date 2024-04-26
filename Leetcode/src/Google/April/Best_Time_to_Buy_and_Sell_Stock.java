package Google.April;

public class Best_Time_to_Buy_and_Sell_Stock {

    public int maxProfit(int[] prices) {
        int minSoFar = Integer.MAX_VALUE;
        int ans = Integer.MIN_VALUE;

        for (int i=0;i<prices.length;i++){
            minSoFar = Math.min(minSoFar,prices[i]);
            ans = Math.max(ans, prices[i]-minSoFar);
        }
        return ans;
    }

}
