package Google.August;

public class Decode_Ways {



    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0]=1;
        for (int i=1;i<=n;i++){
            if(s.charAt(i-1)!='0'){
                dp[i]=dp[i-1];
            }
            if(i>=2 && Integer.parseInt(s.substring(i-2,i))>=10 && Integer.parseInt(s.substring(i-2,i))<=26){
                dp[i]+= dp[i-2];
            }
        }

        return dp[n];
    }

}
