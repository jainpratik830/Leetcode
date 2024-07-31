package Google.July;

import java.util.Arrays;

public class Distinct_Subsequences_II {

    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        int n = s.length();
        int[] dp = new int[n+1];
        int[] last = new int[26];
        Arrays.fill(last,-1);
        dp[0]=1;
        for (int i=0;i<n;i++){
            dp[i+1]= 2*dp[i]%MOD;
            int x = s.charAt(i)-'a';
            if (last[x]!=-1){
                dp[i+1] -=  dp[last[x]];
            }
            dp[i+1] %= MOD;
            last[x] = i;
        }

        dp[n]--;
        if (dp[n]<0){
            dp[n]+= MOD;
        }
        return dp[n];
    }


}
