package Mission_2025.January.DP;

public class Longest_Increasing_Path_in_a_Matrix {

    int[][] dp;
    boolean[][] visited;
    int m,n;

    public int longestIncreasingPath(int[][] matrix) {
        int ans =0;
        this.m = matrix.length;
        this.n = matrix[0].length;

        dp = new int[m][n];
        visited= new boolean[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (!visited[i][j]){
                    dfs(i,j,matrix);
                }
                ans = Math.max(ans,dp[i][j]);
            }
            // System.out.println(Arrays.toString(dp[i]));
        }
        return ans;
    }

    public int dfs(int i,int j,int[][] matrix){
        // System.out.println("mat="+matrix[i][j]);
        if (dp[i][j]!=0){
            return dp[i][j];
        }

        visited[i][j]= true;

        int ans =1;
        int[] x = {0,0,-1,1};
        int[] y= {-1,1,0,0};

        for (int k=0;k<4;k++){
            // System.out.println("i="+(i+x[k])+" j="+(j+y[k]));
            // System.out.println((i+x[k]>=0 && i+x[k]<m && j+y[k]>=0 && j+y[k]<n));
            if (i+x[k]>=0 && i+x[k]<m && j+y[k]>=0 && j+y[k]<n &&  matrix[i+x[k]][j+y[k]]>matrix[i][j]){
                // System.out.println("2 i="+(i+x[k])+" j="+(j+y[k]));
                ans = Math.max(ans,1+dfs(i+x[k],j+y[k],matrix));
            }
        }
        dp[i][j]=ans;
        return ans;

    }

}
