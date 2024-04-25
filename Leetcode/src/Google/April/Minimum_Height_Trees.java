package Google.April;

import java.util.*;

public class Minimum_Height_Trees {


    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        if (n<2){
            ArrayList<Integer> centroids = new ArrayList<>();
            for (int i = 0; i < n; i++)
                centroids.add(i);
            return centroids;
        }

        Map<Integer,List<Integer>> adjlist =new HashMap<>();
        int[] topologicalSort = new int[n];
        for (int i=0;i< edges.length;i++){
            adjlist.putIfAbsent(edges[i][0],new ArrayList<>());
            adjlist.putIfAbsent(edges[i][1],new ArrayList<>());
            adjlist.get(edges[i][0]).add(edges[i][1]);
            adjlist.get(edges[i][1]).add(edges[i][0]);
            topologicalSort[edges[i][0]]++;
            topologicalSort[edges[i][1]]++;
        }

        int count  = n;
        Queue<Integer> leaves = new LinkedList<>();
        for (int i=0;i<n;i++){
            if (adjlist.get(i).size()==1){
                leaves.add(i);
            }
        }

        while (count>2){

            int size = leaves.size();
            count-=size;
            for (int i=0;i<size;i++){
                int curr = leaves.poll();
                for (int j:adjlist.get(curr)){
                    topologicalSort[j]--;
                    if (topologicalSort[j]==1){
                        leaves.add(j);
                    }
                }


            }

        }

        return new ArrayList<>(leaves);

    }

}
