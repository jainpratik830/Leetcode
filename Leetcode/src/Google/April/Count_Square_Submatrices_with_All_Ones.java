package Google.April;

public class Count_Square_Submatrices_with_All_Ones {

    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int ans =0;

        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (i==0 || j==0){
                    dp[i][j]=matrix[i][j];
                    ans += dp[i][j];
                    continue;
                }

                if (matrix[i][j]==1){
                    dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
                    ans += dp[i][j];
                }
            }
        }

        return ans;
    }


}
