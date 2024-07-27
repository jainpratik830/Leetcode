package Google.July;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Count_Vowels_Permutation {

    int mod = 1000000007;

    public int countVowelPermutation(int n) {

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i=0;i<5;i++)
            map.put(i,new ArrayList<>());

        map.get(0).add(1);
        map.get(1).add(0);
        map.get(1).add(2);
        map.get(2).add(0);
        map.get(2).add(1);
        map.get(2).add(3);
        map.get(2).add(4);
        map.get(3).add(2);
        map.get(3).add(4);
        map.get(4).add(0);
        int[][] dp= new int[n][5];
        Arrays.fill(dp[0],1);
        for (int i=1;i<n;i++){
            for (int j=0;j<5;j++){
                for (int k:map.get(j))
                    dp[i][k] =(dp[i][k]+ dp[i-1][j])%mod;
            }
        }


        int ans =0;
        for (int i:dp[n-1]){
            ans+=i;
            ans%=mod;
        }

        return ans;
    }

}
