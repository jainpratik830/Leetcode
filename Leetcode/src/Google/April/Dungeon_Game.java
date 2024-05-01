package Google.April;

import java.util.Arrays;

public class Dungeon_Game {

    int inf = Integer.MAX_VALUE;
    int m,n;

    public int getMinHealth(int nextRow,int nextCol,int[][] dp,int curr){

        if (nextRow>=m || nextCol>=n){
            return inf;
        }

        int next = dp[nextRow][nextCol];
        return Math.max(next-curr,1);

    }

    public int calculateMinimumHP(int[][] dungeon) {

        m = dungeon.length;
        n= dungeon[0].length;
        int[][] dp = new int[m][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, this.inf);
        }
        for (int i=m-1;i>=0;i--){
            for (int j=n-1;j>=0;j--){

                int curr_cell = dungeon[i][j];
                int right = getMinHealth(i,j+1,dp,curr_cell);
                int left = getMinHealth(i+1,j,dp,curr_cell);

                int next = Math.min(left,right);
                if (next!=inf){
                    dp[i][j]=next;
                }else {
                    dp[i][j] = curr_cell>=0 ? 1 : 1-curr_cell;
                }
            }
        }


        return dp[0][0];


    }

}
