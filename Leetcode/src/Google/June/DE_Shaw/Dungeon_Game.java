package Google.June.DE_Shaw;

import java.util.Arrays;

public class Dungeon_Game {

    public int inf = Integer.MAX_VALUE;

    public int minHeath(int r,int c,int[][] dp,int curr){
        if (r>=dp.length || c>=dp[0].length){
            return inf;
        }

        int next = dp[r][c];
        return Math.max(next-curr,1);
    }

    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        for (int i=0;i<m;i++){
            Arrays.fill(dp[i],inf);
        }

        for (int i=m-1;i>=0;i--){
            for (int j=n-1;j>=0;j--){
                int curr = dungeon[i][j];
                int right = minHeath(i,j+1,dp,curr);
                int down = minHeath(i+1,j,dp,curr);

                int min  =Math.min(right,down);
                if (min==inf){
                    dp[i][j]=curr >=0 ? 1 : 1-curr;
                }else {
                    dp[i][j]=min;
                }
            }
        }

        return dp[0][0];
    }

}
