package Mission_2025.January.DP;

public class Distinct_Subsequences {

    Integer[][] dp;

    public int helper(String s,String t,int i,int j,int ignore){

        if (j==t.length()){
            return 1;
        }

        if (i==s.length() || j==t.length()){
            return 0;
        }

        if (dp[i][j]!=null){
            return dp[i][j];
        }

        int count =0;
        if (s.charAt(i)==t.charAt(j)){
            count+= helper(s,t,i+1,j+1,ignore);
        }

        count+= helper(s,t,i+1,j,ignore+1);

        return dp[i][j]=count;

    }

    public int numDistinct(String s, String t) {
        dp= new Integer[s.length()][t.length()];
        return helper(s,t,0,0,0);
    }

}
