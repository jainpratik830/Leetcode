package Google.June.DE_Shaw;

import java.util.Arrays;
import java.util.Comparator;

public class Minimum_Number_of_Taps_Water_a_Garden {

    public int minTaps(int n, int[] ranges) {
        int ans = 0;
        int[][] intervals = new int[n+1][2];
        for (int i=0;i<=n;i++){
            intervals[i][0]=  Math.max(0,i-ranges[i]);
            intervals[i][1]=  Math.min(n,i+ranges[i]);
        }
        Arrays.sort(intervals, Comparator.comparingInt(i->i[0]));

        int i =0;
        int currEnd = 0;
        int start = 0;

        while (start<n){
            while (i<=n && intervals[i][0]<=start){
                currEnd = Math.max(currEnd,intervals[i][1]);
                i++;

            }

            if (start==currEnd){
                return -1;
            }

            start = currEnd;
            ans++;


        }

        return ans;
    }

}
