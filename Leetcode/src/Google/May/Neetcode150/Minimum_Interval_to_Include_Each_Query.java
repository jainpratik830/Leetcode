package Google.May.Neetcode150;

import java.util.*;

public class Minimum_Interval_to_Include_Each_Query {

    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] ans = new int[queries.length];
        int[]  q= queries.clone();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        Arrays.fill(ans,-1);
        Arrays.sort(intervals, Comparator.comparingInt(a->a[0]));
        Arrays.sort(q);
        HashMap<Integer,Integer> qMap = new HashMap<>();
        int curr =0;
        for (int i=0;i<queries.length;i++) {

            while (curr < intervals.length && intervals[curr][0] <= q[i]) {
                map.put(intervals[curr][1] - intervals[curr][0] + 1, intervals[curr][1]);
                curr++;
            }
            while (!map.isEmpty() && map.firstEntry().getValue() < q[i]) {
                map.pollFirstEntry();
            }
            qMap.put(q[i], map.isEmpty() ? -1 : map.firstKey());

        }

        for (int i=0;i<queries.length;i++){
            ans[i] = qMap.get(queries[i]);

        }
        return ans;
    }



}
