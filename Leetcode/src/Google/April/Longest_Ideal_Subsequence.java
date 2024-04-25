package Google.April;

public class Longest_Ideal_Subsequence {



    public int longestIdealString(String s, int k) {
        int[] dp= new int[26];
        int ans =1;

        for (int i=0;i<s.length();i++){
            int curr = s.charAt(i)-'a';
            for (int j=curr;j>=0 && j>=curr-k;j--){
                dp[curr]= Math.max(dp[curr],dp[j]+1);
            }

            for (int j=curr+1;j<26 && j<=curr+k;j++){
                dp[curr]= Math.max(dp[curr],dp[j]+1);
            }

            ans = Math.max(ans,dp[curr]);
        }


        return ans;
    }

}
