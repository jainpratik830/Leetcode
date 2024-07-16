package Google.July;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        int ans =Integer.MAX_VALUE;
        int m = triangle.size();
        int n = triangle.get(triangle.size()-1).size();
        int[] dp = new int[n];
//        for (int[] i:dp){
            Arrays.fill(dp,Integer.MAX_VALUE);
//        }

        dp[0]=triangle.get(0).get(0);
        for (int i=1;i<m;i++){
            int[] prev = dp.clone();

            for (int j=0;j<triangle.get(i).size();j++){
                if (j==0){
                    dp[j]=triangle.get(i).get(j)+prev[j];
                }else {
                    dp[j] = Math.min(prev[j],prev[j-1])+triangle.get(i).get(j);
                }
            }
        }

        for (int i=0;i<n;i++){
            ans =Math.min(ans,dp[i]);
        }
        return ans;
    }

}
