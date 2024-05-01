package Google.April;

public class Unique_Paths_II {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;
        int[] dp=new int[m];
        if(obstacleGrid[0][0]==1 || obstacleGrid[n-1][m-1]==1){
            return 0;
        }
        dp[0]=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(obstacleGrid[i][j]==1){
                    dp[j]=0;
                }

                else if(i==0 && j==0){
                    dp[j]=1;
                }else if(i==0){
                    dp[j]=dp[j-1];
                }else if(j==0){
                    dp[j]=dp[j];
                }
                else{
                    dp[j]=dp[j]+dp[j-1];
                }
            }
        }


        return dp[m-1];
    }

}
