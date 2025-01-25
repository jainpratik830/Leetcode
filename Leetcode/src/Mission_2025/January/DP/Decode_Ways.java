package Mission_2025.January.DP;

import java.util.Arrays;

public class Decode_Ways {

    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        dp[0]=1;
        if (s.charAt(0)=='0'){
            return 0;
        }
        for (int i=1;i<=s.length();i++){
            dp[i]=dp[i-1];
            if (i>1) {
                if (s.charAt(i - 1) == '0' ) {
                    if ((s.charAt(i-2)=='1' || s.charAt(i-2)=='2'))
                        dp[i] = dp[i - 2];
                    else{
                        return 0;
                    }
                }
                else if (s.charAt(i - 2) == '1') {
                    dp[i] += dp[i - 2];
                } else if (s.charAt(i - 2) == '2' && s.charAt(i - 1) >= '0' && s.charAt(i - 1) <= '6') {
                    dp[i] += dp[i - 2];
                }
            }
        }
        // System.out.println(Arrays.toString(dp));
        return dp[s.length()];
    }

}
