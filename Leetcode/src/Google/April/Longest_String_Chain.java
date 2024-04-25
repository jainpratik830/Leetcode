package Google.April;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Longest_String_Chain {

    public int longestStrChain(String[] words) {
        Map<String,Integer> map = new HashMap<>();
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
               return o1.length()-o2.length();
            }
        });
        int max  = 0;
        for (int i=0;i<words.length;i++){
            map.put(words[i],i);
        }
        int ans =0;
        int[] dp = new int[words.length];
        for (int i=0;i<words.length;i++){
            dp[i]=1;
            String curr = words[i];
            for(int j=0;j<curr.length();j++){
                String newCurr = curr.substring(0,j)+curr.substring(j+1);
                if (map.containsKey(newCurr)){
                    dp[i]= Math.max(dp[i],dp[map.get(newCurr)]+1);
                }

            }
            ans = Math.max(ans,dp[i]);
        }


        return ans;

    }

}
