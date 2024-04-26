package Google.April;

public class Best_Time_to_Buy_and_Sell_Stock_II {

    public int maxProfit(int[] prices) {
        int ans = 0;

        for (int i=0;i<prices.length;i++){
            if (i==0){
                continue;
            }
            if (prices[i]>prices[i-1]){
                ans += prices[i]-prices[i-1];
            }
        }
        return ans;
    }

}
