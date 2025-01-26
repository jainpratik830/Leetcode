package Mission_2025.January.DP;

public class Regular_Expression_Matching {

    Boolean[][] dp;

    public boolean helper(String s, String p,int i,int j){

        if (dp[i][j]!=null){
            return dp[i][j];
        }

        boolean ans=false;
        if (j==p.length()){
            ans= i==s.length();
        }else {
            boolean firstMatch = (i<s.length() &&  (p.charAt(j)==s.charAt(i) || p.charAt(j)=='.'));
            if(p.length()>j+1 && p.charAt(j+1)=='*'){
                ans =  (
                        helper(s,p,i,j+2) ||
                                (firstMatch && helper(s,p,i+1,j))
                );
            }else{
                ans = (firstMatch && helper(s,p,i+1,j+1));
            }
        }

        dp[i][j]= ans;
        return ans;

    }


    public boolean isMatch(String s, String p) {
        dp = new Boolean[s.length()+1][p.length()+1];

        return helper(s,p,0,0);

    }

}
