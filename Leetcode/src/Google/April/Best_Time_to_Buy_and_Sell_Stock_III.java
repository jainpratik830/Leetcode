package Google.April;

public class Best_Time_to_Buy_and_Sell_Stock_III {

    public int maxProfitHelper(int[] prices,int start,int end) {

        int minSoFar = Integer.MAX_VALUE;
        int ans = 0;

        for (int i=start;i<end;i++){
            minSoFar = Math.min(minSoFar,prices[i]);
            ans = Math.max(ans, prices[i]-minSoFar);
        }
        // System.out.println("start="+start+" end="+end+" ans="+ans);
        return ans;
    }

    public int maxProfit(int[] prices) {
        int ans = 0;

        for (int i=0;i<=prices.length;i++){
            ans =Math.max(maxProfitHelper(prices,0,i)+maxProfitHelper(prices,i,prices.length),ans);
        }
        return ans;
    }

}
