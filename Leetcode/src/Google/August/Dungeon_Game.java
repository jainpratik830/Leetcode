package Google.August;

import java.util.Arrays;

public class Dungeon_Game {

    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m+1][n+1];
        for (int[] i:dp){
            Arrays.fill(i,Integer.MAX_VALUE);
        }
        dp[m][n-1] = dp[m-1][n] = 1;

        for (int i=m-1;i>=0;i--){
            for (int j=n-1;j>=0;j--){

                dp[i][j] = Math.min(dp[i+1][j],dp[i][j+1]);

                dp[i][j]-=dungeon[i][j];
                dp[i][j]= (dp[i][j]<=0 ? 1: dp[i][j] );
            }
        }

        return dp[0][0];


    }

}





