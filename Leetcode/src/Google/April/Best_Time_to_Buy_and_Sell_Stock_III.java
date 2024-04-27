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

        int[] left = new int[prices.length];
        int[] right = new int[prices.length+1];
        int leftMin = prices[0];
        int rightMax = prices[prices.length-1];
        for (int i=1;i<prices.length;i++){
            leftMin  = Math.min(leftMin,prices[i]);
            left[i] = Math.max(left[i-1],prices[i]-leftMin);

            int r = prices.length-1-i;
            rightMax = Math.max(rightMax,prices[r]);
            right[r] = Math.max(right[r+1],rightMax-prices[r]);

        }



        for (int i=0;i<prices.length;i++){
            ans =Math.max(left[i]+right[i+1],ans);
        }
        return ans;
    }

}
