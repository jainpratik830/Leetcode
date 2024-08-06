package Google.August;

import java.util.ArrayList;
import java.util.List;

public class Perfect_Squares {

    public List<Integer> getSquares(int n)
    {
        List<Integer> list= new ArrayList<>();
        for (int i=1;i*i<=n;i++){
            list.add(i*i);
        }
        return list;
    }
    public int numSquares(int n) {
        List<Integer> list = getSquares(n);
        int[] dp = new int[n+1];
        dp[0]=1;
        for (int i=1;i<=n;i++){
            dp[i]= Integer.MAX_VALUE;
            for (int j=0;j<list.size();j++){

                if (i==list.get(j)){
                    dp[i]=1;
                }
                if (i>list.get(j) && dp[i-list.get(j)]!=Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i],1+dp[i-list.get(j)]);
                }

            }
//            System.out.println(Arrays.toString(dp));
        }

        return dp[n]==Integer.MAX_VALUE ? -1 : dp[n];

    }

}
