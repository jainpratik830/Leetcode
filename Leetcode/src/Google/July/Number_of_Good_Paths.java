package Google.July;

import java.util.*;

public class Number_of_Good_Paths {



    class UnionFind {

        int size;
        int[] rank;
        int[] parent;

        public UnionFind(int size){
            this.size=size;
            this.rank = new int[size];
            parent =new int[size];
            for (int i=0;i<size;i++){
                parent[i]=i;
                rank[i]=1;
            }
        }

        public int findParent(int x){
            if (parent[x]!=x){
                parent[x] = findParent(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x,int y){

            int parent_x = findParent(x);
            int parent_y = findParent(y);

            if (parent_x==parent_y){
                return true;
            }

            if (rank[parent_x]>rank[parent_y]){
                parent[parent_y]=parent_x;
                rank[x]+=rank[y];
            }else {
                parent[parent_x]=parent_y;
                rank[y]+=rank[x];
            }
            return false;
        }

    }

    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            adj.computeIfAbsent(a, value -> new ArrayList<Integer>()).add(b);
            adj.computeIfAbsent(b, value -> new ArrayList<Integer>()).add(a);
        }

        int n = vals.length;
        // Mapping from value to all the nodes having the same value in sorted order of
        // values.
        TreeMap<Integer, List<Integer>> valuesToNodes = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            valuesToNodes.computeIfAbsent(vals[i], value -> new ArrayList<Integer>()).add(i);
        }

        UnionFind dsu = new UnionFind(n);
        int goodPaths = 0;

        // Iterate over all the nodes with the same value in sorted order, starting from
        // the lowest value.
        for (int value : valuesToNodes.keySet()) {
            // For every node in nodes, combine the sets of the node and its neighbors into
            // one set.
            for (int node : valuesToNodes.get(value)) {
                if (!adj.containsKey(node))
                    continue;
                for (int neighbor : adj.get(node)) {
                    // Only choose neighbors with a smaller value, as there is no point in
                    // traversing to other neighbors.
                    if (vals[node] >= vals[neighbor]) {
                        dsu.union(node, neighbor);
                    }
                }
            }
            // Map to compute the number of nodes under observation (with the same values)
            // in each of the sets.
            Map<Integer, Integer> group = new HashMap<>();
            // Iterate over all the nodes. Get the set of each node and increase the count
            // of the set by 1.
            for (int u : valuesToNodes.get(value)) {
                group.put(dsu.findParent(u), group.getOrDefault(dsu.findParent(u), 0) + 1);
            }
            // For each set of "size", add size * (size + 1) / 2 to the number of goodPaths.
            for (int key : group.keySet()) {
                int size = group.get(key);
                goodPaths += size * (size + 1) / 2;
            }
        }
        return goodPaths;
    }










    public int numberOfGoodPaths2(int[] vals, int[][] edges) {
        int ans = vals.length;

        HashMap<Integer,Integer> freq = new HashMap<>();
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge:edges){
            adj.putIfAbsent(edge[0],new ArrayList<>());
            adj.putIfAbsent(edge[1],new ArrayList<>());
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        // System.out.println(adj);
        for (int i:vals){
            freq.put(i,freq.getOrDefault(i,0)+1);
        }
        int temp=0;
        // System.out.println(freq);
        for (int i=0;i<vals.length;i++){
            if (freq.get(vals[i])>1){
                temp += bfs(i,adj,vals);
            }
        }


        return ans+temp/2;
    }

    public int bfs(int start,HashMap<Integer, List<Integer>> adj,int[] vals){
        int ans =0;
        boolean[] visited = new boolean[vals.length];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start,1});

        while (!queue.isEmpty()){

            int[] curr = queue.poll();

            if (curr[0]!=start && vals[curr[0]]==vals[start]){
                ans+=1;
            }

            for (int i:adj.getOrDefault(curr[0],new ArrayList<>())){
                if (visited[i]){
                    continue;
                }
                if (vals[i]>vals[start]){
                    continue;
                }
                queue.add(new int[]{i,curr[1]+1});
                visited[i]=true;
            }

        }

        return ans;

    }

}
