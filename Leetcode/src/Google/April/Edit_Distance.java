package Google.April;

public class Edit_Distance {

    int[][] dp;
    int m,n;

    public int minDistance(String word1, String word2) {
        int ans =0;
        m = word1.length();
        n=word2.length();
        dp= new int[m+1][n+1];

        checkDist(m,n,word1,word2);


        return dp[m][n];
    }

    public int checkDist(int i,int j,String word1,String word2){



        if (i==0){
            return j;
        }
        if (j==0){
            return i;
        }

        if (dp[i][j]!=0){
            return dp[i][j];
        }

        if (word1.charAt(i-1)==word2.charAt(j-1)){
            return checkDist(i-1,j-1,word1,word2);
        }else {
            int ans = Math.min(checkDist(i-1,j,word1,word2),checkDist(i-1,j-1,word1,word2));
            ans = Math.min(checkDist(i,j-1,word1,word2),ans);
            dp[i][j]=ans+1;
            return ans+1;
        }

    }

}
