package Google.August;

public class Stone_Game_II {

    private int winner(int[] piles, int[][][] dp, int p, int i, int m) {

        if (i==piles.length) {
            return 0;
        }

        if (dp[p][i][m]!=-1){
            return dp[p][i][m];
        }


        int sum =0;
        int res = p == 1 ? 1000000 : -1;
        for (int x=1;x<=Math.min(2*m,piles.length-i);x++){
            sum += piles[i+x-1];
            if (p==0){
                res = Math.max(res,sum+winner(piles,dp,1,i+x,Math.max(m,x)));
            }else {
                res = Math.min(res,winner(piles,dp,0,i+x,Math.max(m,x)));
            }
        }

        return dp[p][i][m]=res;
    }

    public int stoneGameII(int[] piles) {

        int[][][] dp = new int[2][piles.length + 1][piles.length + 1];
        for (int p = 0; p < 2; p++) {
            for (int i = 0; i <= piles.length; i++) {
                for (int m = 0; m <= piles.length; m++) {
                    dp[p][i][m] = -1;
                }
            }
        }
        return winner(piles,dp,0,0,1);

    }

}
