package Google.April;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Sum_of_Distances_in_Tree2 {

    int[] result,count;
    int N;
    HashMap<Integer, ArrayList<Integer>> map;

    public int[] sumOfDistancesInTree(int N, int[][] edges) {

        count =new int[N];
        result = new int[N];
        Arrays.fill(count,1);
        map = new HashMap<>();
        this.N = N;
        for (int[] edge:edges){
            map.putIfAbsent(edge[0],new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
            map.putIfAbsent(edge[1],new ArrayList<>());
            map.get(edge[1]).add(edge[0]);
        }

        dfs(0,-1);
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(count));
        dfs2(0,-1);

        return result;
    }

    public void dfs(int node,int parent){
        for (int child : map.getOrDefault(node,new ArrayList<>())){
            if (child !=parent){
                dfs(child,node);
                count[node]+= count[child];
                result[node] += result[child]+count[child];
            }
        }
    }
    public void dfs2(int node, int parent){
        for (int child :map.getOrDefault(node,new ArrayList<>() )){
            if (child !=parent){
                result[child] = result[node]-count[child]+N - count[child];
                dfs2(child,node);
            }
        }
    }
}
