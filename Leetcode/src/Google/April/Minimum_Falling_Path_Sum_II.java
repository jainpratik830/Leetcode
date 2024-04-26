package Google.April;

import java.util.Arrays;

public class Minimum_Falling_Path_Sum_II {


    Integer[][] dp;
    public int helper(int[][] grid,int col,int row){

        if (row==grid.length-1){
            return grid[row][col];
        }

        if(dp[row][col]!=null){
            return dp[row][col];
        }


        int min = Integer.MAX_VALUE;

        for (int i=0;i<grid[0].length;i++){
            if (i!=col)
                min  = Math.min(helper(grid,i,row+1),min);

        }


        return dp[row][col]=min+grid[row][col];
    }

    public int minFallingPathSum(int[][] grid) {
        dp = new Integer[grid.length][grid[0].length];

        int ans = Integer.MAX_VALUE;
        for (int i=0;i<grid[0].length;i++){
            ans= Math.min(ans,helper(grid,i,0));
        }

        return ans;
    }



}
