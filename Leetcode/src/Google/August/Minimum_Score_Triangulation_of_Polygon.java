package Google.August;

public class Minimum_Score_Triangulation_of_Polygon {

    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];

        for (int len=2;len<n;len++){

            for (int i=0,j=len;j<n;i++,j++){
                if (len==2){
                    dp[i][j]=values[i]*values[i+1]*values[i+2];
                }else {
                    int min = Integer.MAX_VALUE ;
                    for (int k=i+1;k<j;k++){

                        int left = dp[i][k];
                        int right = dp[k][j];
                        int triangle = values[i] * values[j] * values[k];

                        min = Math.min(min,left+right+triangle);

                    }

                    dp[i][j]=min;

                }
            }

        }

        // Call the helper method for the entire range of the input array
        return dp[0][n-1];
    }

}
