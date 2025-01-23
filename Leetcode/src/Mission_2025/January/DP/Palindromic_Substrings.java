package Mission_2025.January.DP;

public class Palindromic_Substrings {

    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int ans = 0;
//        if(s.length()==1){
//            return s;
//        }
        for (int i=0;i<n;i++){
            dp[i][i]=true;
            ans++;
        }
        for (int length = 1;length<n;length++){
            for (int i=0;i<n-length;i++){
                int j= i+length;
                if(i==j-1 && s.charAt(i)==s.charAt(j)){
                    dp[i][j]=true;
                    ans++;
                    continue;
                }
                if (dp[i+1][j-1] && s.charAt(i)==s.charAt(j)){
                    dp[i][j]=true;
                    ans++;
                }
            }
        }

        return ans;
    }

}
