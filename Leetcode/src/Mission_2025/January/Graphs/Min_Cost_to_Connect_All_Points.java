package Mission_2025.January.Graphs;

import java.util.*;

public class Min_Cost_to_Connect_All_Points {

    public int minCostConnectPoints(int[][] points) {
        if(points == null || points.length == 0){
            return -1;
        }

        int n= points.length;
        HashMap<Integer, List<int[]>> map= new HashMap<>();
        for (int i=0;i<n;i++){
            int x = points[i][0];
            int y = points[i][1];
            for (int j=i+1;j<n;j++){
                int x2 = points[j][0];
                int y2= points[j][1];
                int dist = Math.abs(x-x2)+Math.abs(y-y2);
                map.putIfAbsent(i,new ArrayList<>());
                map.putIfAbsent(j,new ArrayList<>());
                map.get(i).add(new int[]{j,dist});
                map.get(j).add(new int[]{i,dist});
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(i->i[1]));
        Set<Integer> visited = new HashSet<>();
        pq.add(new int[]{0,0});
        // visited.add(0);
        int ans = 0;
        while (!pq.isEmpty()){
            if (visited.size()==n){
                return ans;
            }
            int[] curr = pq.poll();
            if(visited.contains(curr[0])){
                continue;
            }
            visited.add(curr[0]);
            ans += curr[1];
            // System.out.println("Dest="+curr[0]+" dist="+curr[1]);
            for (int[] neigh:map.getOrDefault(curr[0],new ArrayList<>())) {
                if (!visited.contains(neigh[0])) {
                    pq.add(neigh);
                    // visited.add(neigh[0]);
                }
            }
        }

        return ans;
    }


}
