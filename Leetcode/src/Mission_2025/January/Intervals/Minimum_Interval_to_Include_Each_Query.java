package Mission_2025.January.Intervals;

import java.util.*;

public class Minimum_Interval_to_Include_Each_Query {


    public int[] minInterval(int[][] intervals, int[] queries) {

        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int[][] sortedQuery = new int[queries.length][2];
        for (int i=0;i<queries.length;i++){
            sortedQuery[i]=new int[]{queries[i],i};
        }
        Arrays.sort(sortedQuery,Comparator.comparingInt(a->a[0]));
        int[] ans = new int[queries.length];
        int j=0;
        PriorityQueue<int[]> pq=  new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        for (int i=0;i<queries.length;i++){

            while (j<intervals.length && intervals[j][0]<=sortedQuery[i][0]){
                pq.add(new int[]{intervals[j][1]-intervals[j][0]+1,intervals[j][0],intervals[j][1]});
                j++;
            }

            while (!pq.isEmpty() && pq.peek()[2]<sortedQuery[i][0]){
                pq.poll();
            }

            ans[sortedQuery[i][1]]= pq.isEmpty() ? -1 : pq.peek()[0];
        }
        return ans;
    }

}
