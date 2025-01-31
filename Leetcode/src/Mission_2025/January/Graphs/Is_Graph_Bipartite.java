package Mission_2025.January.Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Is_Graph_Bipartite {

    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V];
        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!bfs(i, color, graph)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean bfs(int start, int[] color, int[][] graph) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        color[start] = 0;

        while (!queue.isEmpty()) {
            int poll = queue.poll();
            int currentColor = color[poll];

            for (int neighbor : graph[poll]) {
                if (color[neighbor] == -1) {
                    queue.add(neighbor);
                    color[neighbor] = 1 - currentColor;
                } else if (color[neighbor] == currentColor) {
                    return false;
                }
            }
        }

        return true;
    }

}
