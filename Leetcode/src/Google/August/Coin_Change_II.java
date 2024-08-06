package Google.August;

public class Coin_Change_II {

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0]=1;
        for (int j=0;j<coins.length;j++){
//            dp[i]= Integer.MAX_VALUE;
            for (int i=coins[j];i<=amount;i++){

//                if (i==coins[j]){
//                    dp[i]+=1;
//                }
//                if (i>coins[j] && dp[i-coins[j]]!=Integer.MAX_VALUE){
                    dp[i] += dp[i-coins[j]];
//                }

            }
//            System.out.println(Arrays.toString(dp));
        }

        return dp[amount];
    }
}
