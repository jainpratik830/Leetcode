package Google.August;

public class Decode_Ways_II {

    public int numDecodings(String s) {
        int n = s.length();
        long[] dp = new long[n+1];
        dp[0]=1;
        // dp[1] = s.charAt(0) == '*' ? 9 : s.charAt(0) == '0' ? 0 : 1;
        int M = 1000000007;
        for (int i=1;i<=n;i++){

            if(s.charAt(i-1)=='*'){
                dp[i]=(dp[i-1]*9)% M;
                if (i>=2 && (s.substring(i-2,i-1)).equals("*") )
                    dp[i]=(dp[i] +dp[i-2]*15)% M;
                else if (i>=2 && Integer.parseInt(s.substring(i-2,i-1))==1 )
                    dp[i]=(dp[i] +dp[i-2]*9)% M;
                else if (i>=2 && Integer.parseInt(s.substring(i-2,i-1))==2 )
                    dp[i]=(dp[i] +dp[i-2]*6)% M;
            }else {
                if(s.charAt(i-1)!='0'){
                    dp[i]=dp[i-1];
                }
                if(i>=2){
                    if (s.charAt(i - 2) == '1')
                        dp[i] = (dp[i] + dp[i - 2]) % M;
                    else if (s.charAt(i - 2) == '2' && s.charAt(i-1) <= '6')
                        dp[i] = (dp[i] + dp[i - 2]) % M;
                    else if (s.charAt(i - 2) == '*')
                        dp[i] = (dp[i] + (s.charAt(i-1) <= '6' ? 2 : 1) * dp[i - 2]) % M;
                }
                // if(i>=2 && ( s.substring(i-1,i)).equals("*") ||    (Integer.parseInt(s.substring(i-2,i))>=10 && Integer.parseInt(s.substring(i-2,i))<=26)){
                //     dp[i]+= dp[i-2];
                // }
            }


        }

        return (int) dp[n];
    }

}
