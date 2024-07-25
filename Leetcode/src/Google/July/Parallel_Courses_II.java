package Google.July;

import java.util.*;

public class Parallel_Courses_II {

    public int minNumberOfSemesters(int N, int[][] relations, int k) {
        int[] inCount = new int[N + 1]; // or indegree
        List<List<Integer>> graph = new ArrayList<>(N + 1);
        for (int i = 0; i < N + 1; ++i) {
            graph.add(new ArrayList<Integer>());
        }
        for (int[] relation : relations) {
            graph.get(relation[0]).add(relation[1]);
            inCount[relation[1]]++;
        }
        int step = 0;
        int studiedCount = 0;
        Queue<Integer> bfsQueue = new LinkedList<>();
        for (int node = 1; node < N + 1; node++) {
            if (inCount[node] == 0) {
                bfsQueue.add(node);
            }
        }
        // start learning with BFS
        while (!bfsQueue.isEmpty()) {
            // start new semester
            int size = Math.min(k, bfsQueue.size());
            step++;
//            List<Integer> nextQueue = new ArrayList<>();
            for (int i=0;i<size;i++){
                int node = bfsQueue.poll();
                studiedCount++;
                for (int endNode : graph.get(node)) {
                    inCount[endNode]--;
                    // if all prerequisite courses learned
                    if (inCount[endNode] == 0) {
                        bfsQueue.add(endNode);
                    }
                }
            }
//            bfsQueue = nextQueue;
        }

        // check if learn all courses
        return step;
    }

}
