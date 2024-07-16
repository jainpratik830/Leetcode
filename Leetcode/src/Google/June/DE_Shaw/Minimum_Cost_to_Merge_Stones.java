package Google.June.DE_Shaw;

import java.util.List;

public class Minimum_Cost_to_Merge_Stones {



    public int mergeStones(int[] stones, int k) {
        int ans = 0;
        int n=stones.length;
        if ((n-1)%(k-1)!=0){
            return -1;
        }
        int[] prefix = new int[stones.length+1];
        for (int i=0;i<stones.length;i++){
            prefix[i+1]= stones[i]+prefix[i];
        }

        int[][] dp = new int[n][n];
        for (int len=k;len<=n;len++){
            for (int i=0;i+len<=n;i++){
                int j = i+len-1;
                dp[i][j]=Integer.MAX_VALUE;
                for (int m=i;m<j;m+=k-1){
                    dp[i][j]= Math.min(dp[i][j],dp[i][m]+dp[m+1][j]);
                }
                if ((len-1)%(k-1)==0){
                    dp[i][j] += prefix[j+1]-prefix[i];
                }
            }
        }




        return dp[0][n - 1];
    }

}
