package Google.April;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Path_With_Minimum_Effort {

    boolean[][] visited;
    int[] x = {0,0,-1,1};
    int[] y = {-1,1,0,0};

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        visited = new boolean[m][n];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        priorityQueue.add(new int[]{0,0,0});

        while (!priorityQueue.isEmpty()){

            int[] curr = priorityQueue.poll();

            if (curr[1]==m-1 && curr[2]== n-1){
                return curr[0];
            }

            visited[curr[1]][curr[2]]=true;

            for (int k=0;k<4;k++){
                int i = curr[1] +x[k];
                int j = curr[2] + y[k];
                if (i>=0 && i<m && j>=0 && j<n && !visited[i][j] ){
                    priorityQueue.add(new int[]{Math.max(curr[0], Math.abs(heights[curr[1]][curr[2]]-heights[i][j])),i,j});
                }
            }
        }



        return -1;
    }

}
