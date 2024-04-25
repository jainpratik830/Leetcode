package Google.April;

import java.util.Arrays;

public class Coin_Change_II {

    int[] coins;
    int[][] memo;

    public int calcWays(int amount,int i){
        if (amount==0){
            return 1;
        }

        if (i==coins.length){
            return 0;
        }

        if (memo[i][amount]!=-1){
            return memo[i][amount];
        }

        if (coins[i]>amount){
            return calcWays(amount,i+1);
        }

        int ans = calcWays(amount-coins[i],i)+calcWays(amount,i+1);
        return memo[i][amount]=ans;

    }

    public int change(int amount, int[] coins) {
        this.coins=coins;
        memo = new int[coins.length][amount+1];
        for (int[] i:memo){
            Arrays.fill(i,-1);
        }

        return calcWays(amount,0);
    }

}
