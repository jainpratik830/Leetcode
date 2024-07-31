package Google.July;

public class Number_of_Unique_Good_Subsequences {

    public int numberOfUniqueGoodSubsequences(String binary) {
        int n = binary.length(), ans = 0, first = n, zero = 0;
        int mod = (int)1e9 + 7;
        int[][] dp = new int[2][n+1];

        for(int i=n-1; i>=0; --i){
            if(binary.charAt(i)=='0') {
                zero = 1;
                dp[0][i] = (dp[0][i+1] + 1 + dp[1][i+1])%mod;
                dp[1][i] = dp[1][i+1];
            }
            else {
                dp[1][i] = ((dp[0][i+1] + 1 + dp[1][i+1]))%mod;
                dp[0][i] = dp[0][i+1];
            }
        }

        return (dp[1][0] + zero)%mod;
    }

}
