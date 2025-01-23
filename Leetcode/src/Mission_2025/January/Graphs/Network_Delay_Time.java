package Mission_2025.January.Graphs;

import java.util.*;

public class Network_Delay_Time {

    public int networkDelayTime(int[][] times, int n, int k) {
        int ans = 0;
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        for (int[] time:times){
            map.putIfAbsent(time[0],new ArrayList<>());
            map.get(time[0]).add(new int[]{time[1],time[2]});
        }
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
        for (int[] i:map.getOrDefault(k,new ArrayList<>())){
            pq.add(i);

        }
        visited.add(k);
        while (!pq.isEmpty()){
            int[] curr = pq.poll();
            if (visited.contains(curr[0])){
                continue;
            }
            visited.add(curr[0]);
            ans = Math.max(ans,curr[1]);
            for (int[] i:map.getOrDefault(curr[1],new ArrayList<>())){
                if (!visited.contains(i[0]))
                    pq.add(new int[]{i[0],curr[1]+i[1]});


            }
        }

        return visited.size()==n ? ans : -1;
    }

}
