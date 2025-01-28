package Mission_2025.January.Intervals;

import java.util.ArrayList;
import java.util.List;

public class Insert_Interval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
       List<int[]> ans = new ArrayList<>();
       int i=0;
       for (;i<intervals.length;i++){
           if (intervals[i][1]>=newInterval[0]){
               break;
           }
           ans.add(intervals[i]);
       }

       int start=  newInterval[0];
       int end = newInterval[1];

        while (i<intervals.length && end>=intervals[i][0]){
           start= Math.min(intervals[i][0],start);
           end= Math.max(intervals[i][1],end);
           i++;
       }
       ans.add(new int[]{start,end});

        for (;i<intervals.length;i++){
            ans.add(intervals[i]);
        }

        return ans.toArray(new int[ans.size()][]);

    }

}
