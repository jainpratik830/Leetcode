package Google.July;

import java.util.Arrays;

public class Minimum_Time_to_Finish_the_Race {

    public int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {
        int[] withoutChange = new int[numLaps+1];
        Arrays.fill(withoutChange,Integer.MAX_VALUE);

        for (int[] tire:tires){

            int base = tire[0];
            int exp = tire[1];
            int sum =0;
            int amount=1;
            for (int i=1;i<=numLaps;i++){
                amount = i==1 ? base : amount*exp;
                if (amount>changeTime+base){
                    break;
                }
                sum+=amount;
                withoutChange[i]=Math.min(sum,withoutChange[i]);

            }
        }
        // System.out.println(Arrays.toString(withoutChange));

        int[] dp = new int[numLaps+1];
        // Arrays.fill(dp,Integer.MAX_VALUE);
        // dp[0]=0;

        for (int i=1;i<=numLaps;i++){

            dp[i] =(int) withoutChange[i];
            for (int j=1;j<i;j++){
                // if (dp[j]==Integer.MAX_VALUE){
                //     continue;
                // }
                dp[i]= Math.min(dp[i],dp[j]+changeTime+dp[i-j]);
            }
        }
        // System.out.println(Arrays.toString(dp));
        return dp[numLaps];


    }
}
