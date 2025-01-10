package Google.August;

import java.util.Arrays;

public class Minimum_Cost_to_Merge_Stones {

    int[][][] dp;

    public int recurse(int i,int j,int piles,int[] prefix,int k){

        if (i==j && piles==1){
            return 0;
        }

        if (i==j){
            return Integer.MAX_VALUE/4;
        }

        if (dp[i][j][piles]!=-1){
            return dp[i][j][piles];
        }

        if (piles==1){
            return dp[i][j][piles]= recurse(i,j,k,prefix,k)+(i==0 ? prefix[j] : prefix[j]-prefix[i-1]);
        }else {
            int cost = Integer.MAX_VALUE/4;
            for (int t=i;t<j;t+=k-1){
                cost = Math.min(cost, recurse(i,t,1,prefix,k)+recurse(t+1,j,piles-1,prefix,k));
            }
            return dp[i][j][piles]=cost;
        }

    }

    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        int[] prefix = new int[n];

        if ((n-1)%(k-1)!=0){
            return -1;
        }
        prefix[0]=stones[0];
        dp = new int[n+1][n+1][k+1];
        for (int i=1;i<n;i++){
            prefix[i] = prefix[i-1]+stones[i];
        }

        for (int[][] a:dp){
            for (int[] i:a){
                Arrays.fill(i,-1);
            }
        }


        return recurse(0,n-1,1,prefix,k);
    }

}
