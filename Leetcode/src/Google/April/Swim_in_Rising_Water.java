package Google.April;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Swim_in_Rising_Water {

    int m,n;
    boolean[][] visited;
    int[] x = {0,0,-1,1};
    int[] y = {-1,1,0,0};

    public int dfs(int[][] grid,int i,int j,int curr_max,boolean[][] visited){


        curr_max = Math.max(curr_max,grid[i][j]);
        if (i==m-1 && j== n-1){
            return curr_max;
         }
        visited[i][j] = true;

        int ans = Integer.MIN_VALUE;
        for (int k=0;k<4;k++){
            if (i+x[k]>=0 && i+x[k]<m && j+y[k]>=0 && j+y[k]<n && !visited[i+x[k]][j+y[k]]){
                ans = Math.max(ans,dfs(grid,i+x[k],j+y[k],curr_max,visited));
            }
        }

        return ans;

    }

    public int swimInWater(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        visited = new boolean[m][n];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        priorityQueue.add(new int[]{grid[0][0],0,0});

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
                    priorityQueue.add(new int[]{Math.max(curr[0],grid[i][j]),i,j});
                }
            }
        }



        return -1;
    }

}
