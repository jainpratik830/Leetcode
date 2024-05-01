package Google.April;

public class Decode_Ways {

    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        if(s.charAt(0)=='0'){
            return 0;
        }

        dp[0]=1;
        if(s.length()<=1){
            return 1;
        }
        dp[1]=1;
        for(int i=2;i<=s.length();i++){
            if(s.charAt(i-1)!='0'){
                dp[i]=dp[i-1];
            }


            if(Integer.parseInt(s.substring(i-2,i))==0){
                return 0;
            }
            if(Integer.parseInt(s.substring(i-2,i))>=10 && Integer.parseInt(s.substring(i-2,i))<=26){
                dp[i]+= dp[i-2];
            }
        }

        return dp[s.length()];

    }

}

