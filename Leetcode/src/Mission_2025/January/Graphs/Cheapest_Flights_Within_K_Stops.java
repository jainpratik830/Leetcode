package Mission_2025.January.Graphs;

import java.util.*;

public class Cheapest_Flights_Within_K_Stops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int ans =0;
        HashMap<Integer, List<int[]>> map= new HashMap<>();
        for (int i=0;i<flights.length;i++){
            int s = flights[i][0];
            int d = flights[i][1];
            int cost = flights[i][2];
            map.putIfAbsent(s,new ArrayList<>());
            // map.putIfAbsent(d,new ArrayList<>());
            map.get(s).add(new int[]{d,cost});
            // map.get(d).add(new int[]{s,cost});

        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(i->i[2]));
        pq.add(new int[]{src,0,0});
        int[] visited = new int[n];
        Arrays.fill(visited,n+1);
        while (!pq.isEmpty()){
            int[] curr= pq.poll();
            if (curr[1]>k+1){
                continue;
            }
            if (curr[0]==dst && curr[1]<=k+1){
                return curr[2];
            }
            // System.out.println("Before Dest="+curr[0]+" hops="+curr[1] +" cost="+curr[2]);

            visited[curr[0]]=curr[1];
            // System.out.println("After Dest="+curr[0]+" hops="+curr[1] +" cost="+curr[2]);
            for (int[] neigh:map.getOrDefault(curr[0],new ArrayList<>())){
                if (visited[neigh[0]] == n+1 || visited[neigh[0]]>curr[1])  {
                    pq.add(new int[]{neigh[0],curr[1]+1,curr[2]+neigh[1]});
                }
            }
        }
        return -1;
    }


}
