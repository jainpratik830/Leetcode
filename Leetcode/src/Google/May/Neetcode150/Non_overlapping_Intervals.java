package Google.May.Neetcode150;

import java.util.Arrays;
import java.util.Comparator;

public class Non_overlapping_Intervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
//                if (o1[0]==o2[0]){
//                    return (o1[1]-o1[0])-((o2[1]-o2[0]));
//                }
                return o1[0]-o2[0];
            }
        });
        for (int[] i:intervals){
            System.out.println(i[0]+"-"+i[1]);
        }
        int count=0;
        int currEnd = Integer.MIN_VALUE;
        for (int i=0;i<intervals.length;i++){
            if (intervals[i][0]<currEnd){
                count++;
            }else {
                currEnd =Math.min(currEnd,intervals[i][1]);
            }
        }

        return count;

    }

}
