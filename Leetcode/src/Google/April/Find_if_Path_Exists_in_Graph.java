package Google.April;

import java.util.*;

public class Find_if_Path_Exists_in_Graph {


    public boolean validPath(int n, int[][] edges, int source, int destination) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();

        for (int[] i:edges){
            adjList.putIfAbsent(i[0],new ArrayList<>());
            adjList.putIfAbsent(i[1],new ArrayList<>());
            adjList.get(i[0]).add(i[1]);
            adjList.get(i[1]).add(i[0]);
        }

        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(source);

        while (!queue.isEmpty()){
            int curr = queue.poll();
            if (curr==destination){
                return true;
            }
            if (visited.contains(curr)){
                continue;
            }

            visited.add(curr);
            for (int i:adjList.get(curr)){
                if (!visited.contains(i)){
                    queue.add(i);
                }
            }

        }
        return false;
    }
}
