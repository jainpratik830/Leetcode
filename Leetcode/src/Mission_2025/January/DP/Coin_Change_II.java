package Mission_2025.January.DP;

import java.util.Arrays;

public class Coin_Change_II {


    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        Arrays.sort(coins);
        dp[0]=1;
        for (int j:coins){
        for (int i=j;i<=amount;i++){

                if (i>=j){
                    dp[i] += dp[i-j];
                }
            }

        }
        System.out.println(Arrays.toString(dp));
        return dp[amount];
    }

}
