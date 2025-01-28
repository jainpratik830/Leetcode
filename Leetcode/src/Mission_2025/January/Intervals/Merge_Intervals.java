package Mission_2025.January.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Merge_Intervals {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
        });

        int i=0;
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        i=1;
        while (i<intervals.length){
            if (result.get(result.size()-1)[1]>=intervals[i][0]){
                result.get(result.size()-1)[0]=Math.min(result.get(result.size()-1)[0],intervals[i][0]);
                result.get(result.size()-1)[1]=Math.max(result.get(result.size()-1)[1],intervals[i][1]);
            }else {
                result.add(intervals[i]);
            }
            i++;
        }
        return result.toArray(new int[result.size()][]);
    }

}
