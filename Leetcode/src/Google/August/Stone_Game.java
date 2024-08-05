package Google.August;

public class Stone_Game {

    public boolean winner(int[] piles,int i,int j,int turn,int alice,int bob,Boolean[][][] dp){

        if (i>j) {
            return alice > bob;
        }

        if (dp[i][j][turn]!=null){
            return dp[i][j][turn];
        }

        if (turn==1){

             dp[i][j][turn]=winner(piles,i+1,j,0,alice+piles[i],bob,dp) || winner(piles,i,j-1,0,alice+piles[j],bob,dp);


        }else {
             dp[i][j][turn]= winner(piles,i+1,j,1,alice,bob+piles[i],dp) || winner(piles,i,j-1,1,alice,bob+piles[j],dp);
        }

        return dp[i][j][turn];
    }

    public boolean stoneGame(int[] piles) {
        Boolean[][][] dp = new Boolean[piles.length][piles.length][2];
        return winner(piles,0,piles.length-1,1,0,0,dp);
    }



}
