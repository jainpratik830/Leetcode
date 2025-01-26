package Mission_2025.January.DP;

public class Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {

    Integer[][] dp;

    public int helper(int i, int[] prices, int indicator) {
        if (i == prices.length) {
            return 0; // No profit possible on or after the last day
        }

        if (dp[i][indicator] != null) {
            return dp[i][indicator];
        }

        if (indicator == 1) { // Ready to buy
            return dp[i][indicator] = Math.max(
                    helper(i + 1, prices, 2) - prices[i], // Buy stock
                    helper(i + 1, prices, 1) // Skip
            );
        } else if (indicator == 2) { // Holding stock
            return dp[i][indicator] = Math.max(
                    helper(i + 1, prices, 3) + prices[i], // Sell stock
                    helper(i + 1, prices, 2) // Skip
            );
        } else { // Cooldown
            return dp[i][indicator] = helper(i + 1, prices, 1); // Move to ready-to-buy state
        }
    }

    public int maxProfit(int[] prices) {
        dp = new Integer[prices.length][4]; // States: 1, 2, 3
        return helper(0, prices, 1); // Start on day 0, ready to buy
    }

}
