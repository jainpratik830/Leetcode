package Mission_2025.January.Intervals;

import java.util.Arrays;
import java.util.Comparator;

public class Non_overlapping_Intervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
        });

        int count  =0;
        int prevEnd = intervals[0][1];
        int i=1;
        while (i<intervals.length){
            if (intervals[i][0]<prevEnd){
                count++;
                prevEnd = Math.min(prevEnd,intervals[i][1]);
            }else {
                prevEnd = intervals[i][1];
            }
            i++;
        }
        return count;
    }

}
