package Mission_2025.January.Daily_Problems;

import java.util.Arrays;

public class Grid_Game {

    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long[] prefix = new long[grid[0].length];
        long[] sufix = new long[grid[0].length];

        for (int i=0;i< prefix.length;i++){
            if (i==0){
                prefix[i]=0;
            }else {
                prefix[i] = prefix[i-1]+grid[1][i-1];
            }
        }

        for (int i=n-1;i>=0;i--){
            if (i==n-1){
                sufix[i]=0;
            }else {
                sufix[i] = sufix[i+1]+grid[0][i+1];
            }
        }

        long max = Long.MAX_VALUE;
        for (int i=0;i<n;i++){
            long top = prefix[i];
            long bottom = sufix[i];
            long max_curr  = Math.max(top,bottom);
            if (max_curr<max){
                max = max_curr;
            }
        }

        return max;
    }

}
