package Google.July;

import java.util.Arrays;

public class Count_Fertile_Pyramids_in_a_Land {

    public int countPyramids(int[][] grid) {
        int m = grid.length;
        int n =grid[0].length;
        int ans =0;
        int[][] dp = new int[m][n];

        for (int i=1;i<m;i++){
            for (int j=1;j<n-1;j++){

                if (grid[i-1][j]==1 && grid[i-1][j-1]==1 && grid[i-1][j+1]==1 && grid[i][j]==1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j + 1])) + 1;
                    ans += dp[i][j];
                }
            }

        }
        for (int[] i:dp){
            System.out.println(Arrays.toString(i));
        }
        System.out.println("Main");
        dp= new int[m][n];

        for (int i=m-2;i>=0;i--){
            for (int j=n-2;j>=1;j--){
                if (grid[i+1][j]==1 && grid[i+1][j-1]==1 && grid[i+1][j+1]==1 && grid[i][j]==1) {
                    dp[i][j] = Math.min(dp[i + 1][j - 1], Math.min(dp[i + 1][j], dp[i + 1][j + 1])) + 1;
                    ans += dp[i][j];
                }
            }
        }
        for (int[] i:dp){
            System.out.println(Arrays.toString(i));
        }

        return ans;
    }

}
