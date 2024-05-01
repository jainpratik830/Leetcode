package Google.April;

import java.util.Random;

public class Count_Number_of_Teams {

    Integer[][][] dp;
    public int helper(int i,int last,int count,int[] rating,int isIncreasing){

        if(count>3){
            return 0;
        }

        if (i>=rating.length && count!=3){
            return 0;
        }

        if (count==3){
            // System.out.println(last);
            return 1;
        }

        if (dp[i][count][isIncreasing]!=null){
            return dp[i][count][isIncreasing];
        }


        int ans =0;
        for (int j=i;j<rating.length;j++){
            if (isIncreasing==0 && rating[j]>last){
                ans += helper(j+1,rating[j],count+1,rating,isIncreasing);
            }
            if(isIncreasing==1 && rating[j]<last){
                ans += helper(j+1,rating[j],count+1,rating,isIncreasing);
            }
        }
        return dp[i][count][isIncreasing]=ans;
    }

    public int numTeams(int[] rating) {
        dp= new Integer[rating.length][3][2];
        return helper(0,Integer.MIN_VALUE,0, rating,0)+helper(0,Integer.MAX_VALUE,0,rating,1);
    }

}
