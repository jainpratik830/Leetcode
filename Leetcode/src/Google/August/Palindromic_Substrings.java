package Google.August;

import java.util.Arrays;

public class Palindromic_Substrings {

    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];

        int count =0;

        for (int i=0;i<s.length();i++){
            for (int j=i;j>=0;j--){
                if (j==i){
                    dp[j][i]=true;
                    count++;
                }
                else if (j==i-1 && s.charAt(j)==s.charAt(i)){
                    dp[j][i]=true;
                    count++;
                }else {
                    if (dp[j+1][i-1] && s.charAt(j)==s.charAt(i)){
                        dp[j][i]=true;
                        count++;
                    }
                }
            }
            System.out.println(Arrays.toString(dp[i]));
        }
        return count;
    }

}
