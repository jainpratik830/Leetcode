package Google.August;

import java.util.Arrays;

public class Last_Stone_Weight_II {

    Integer[][] dp;
    int total;
    public int recurse(int index,int sum,int[] stones,int target){
        if ( sum>=target || index==stones.length){
            return Math.abs(sum-(total-sum));
        }

        if (dp[index][sum]!=null){
            return dp[index][sum];
        }



        dp[index][sum]=Math.min(recurse(index+1,sum+stones[index],stones,target),recurse(index+1,sum,stones,target));

        return  dp[index][sum];

    }

    public int lastStoneWeightII(int[] stones) {
        total= Arrays.stream(stones).sum();
        dp = new Integer[stones.length][total+1];
        return recurse(0,0,stones,total/2);
    }

}
