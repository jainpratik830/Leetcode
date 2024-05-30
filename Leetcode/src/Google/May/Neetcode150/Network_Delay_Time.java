package Google.May.Neetcode150;

import java.util.*;

public class Network_Delay_Time {

    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            map.putIfAbsent(times[i][0], new ArrayList<>());
            map.get(times[i][0]).add(new int[]{times[i][1], times[i][2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
        for (int[] i:map.getOrDefault(k,new ArrayList<>())){
            pq.add(i);
        }
        Set<Integer> visited = new HashSet<>();
        visited.add(k);
        int ans =0;

        while (!pq.isEmpty()){
            int[] curr = pq.poll();
            if (visited.contains(curr[0])){
                continue;
            }
            ans = Math.max(ans,curr[1]);
            for (int[] i:map.getOrDefault(curr[0],new ArrayList<>())){
                if (!visited.contains(i[0])){
                    pq.add(new int[]{i[0],i[1]+curr[1]});
                }
            }
        }

        return visited.size()==n ? ans : -1;

    }


}
