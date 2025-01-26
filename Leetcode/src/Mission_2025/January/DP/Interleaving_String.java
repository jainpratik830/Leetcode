package Mission_2025.January.DP;

public class Interleaving_String {

    Boolean[][] dp;

    public boolean check(String s1,String s2,String s3,int i1,int i2,int i3){
        if (i1==s1.length() && i2==s2.length() && i3==s3.length()){
            return true;
        }

        if (i1<=s1.length() && i2<=s2.length() && dp[i1][i2]!=null){
            return dp[i1][i2];
        }

        boolean res = false;
        if (i1 < s1.length() && s1.charAt(i1) == s3.charAt(i3)) {
            res = check(s1, s2, s3,i1 + 1, i2, i3 + 1 );
        }
        if (!res && i2 < s2.length() && s2.charAt(i2) == s3.charAt(i3)) {
            res = check( s1, s2, s3,i1, i2 + 1,i3 + 1);
        }

        dp[i1][i2] = res;
        return res;

    }

    public boolean isInterleave(String s1, String s2, String s3) {
        dp= new Boolean[s1.length()+1][s2.length()+1];
        return check(s1,s2,s3,0,0,0);
    }

}
