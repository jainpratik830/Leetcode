package Google.April;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Perfect_Squares {

    public List<Integer> squaresList(int n){

        List<Integer> squares = new ArrayList<>();
        for(int i=1;i*i<=n;i++){
            squares.add(i*i);
        }


        return squares;


    }

    public int numSquares(int n) {
        List<Integer> squares = squaresList(n);


        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1;i<=n;i++){
            for(int j=0;j<squares.size();j++){

                if(i>=squares.get(j)){
                    dp[i] = Math.min(dp[i-squares.get(j)]+1,dp[i]);
                }

            }
        }
        // System.out.println(squares);
        // System.out.println(Arrays.toString(dp));
        return dp[n];


    }

}
