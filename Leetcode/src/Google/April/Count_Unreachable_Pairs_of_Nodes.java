package Google.April;

import java.util.*;

public class Count_Unreachable_Pairs_of_Nodes {

//    T = O(n)
//    S = O(n)
    Map<Integer, List<Integer>> map;
    boolean[] visited;

    public long countPairs(int n, int[][] edges) {
        visited = new boolean[n];
        map = new HashMap<>();

        for (int[] edge:edges){
            map.putIfAbsent(edge[0],new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
            map.putIfAbsent(edge[1],new ArrayList<>());
            map.get(edge[1]).add(edge[0]);
        }
        List<Long> list = new ArrayList<>();
        for (int i=0;i<n;i++){
            if (!visited[i]){
                long curr = dfs(i);
                list.add(curr);
            }

        }
        // System.out.println(list);
        long ans =0;
        long sum =0;
        for (int i=0;i<list.size();i++){
            sum += list.get(i);
            ans += list.get(i)*(n-sum);
        }

        return ans;
    }

    public long dfs(int node){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        long count =0;
        // System.out.println("dfs="+node);
        while (!queue.isEmpty()){
            int curr = queue.poll();
            if(visited[curr]){
                continue;
            }
            visited[curr]=true;
            // System.out.println(curr);
            count++;
            for (int i:map.getOrDefault(curr,new ArrayList<>())){
                if (!visited[i]){
                    queue.add(i);
                }
            }
        }
        return count;
    }

}
