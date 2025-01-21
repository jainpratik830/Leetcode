package Mission_2025.January.Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class Rotting_Oranges {

    public int orangesRotting(int[][] grid) {
        int ans =0;
        int m = grid.length;
        int n = grid[0].length;

        int freshCount = 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (grid[i][j]==2){
                    queue.add(new int[]{i,j});
                    visited[i][j]=true;
                }else if (grid[i][j]==1){
                    freshCount++;
                }
            }
        }

        if (freshCount==0){
            return 0;
        }

        int[][] direction = {{0,1},{1,0},{0,-1},{-1,0}};

        while (!queue.isEmpty()){

            int prevFresh = freshCount;
            int size = queue.size();
            while (size-->0){

                int[] curr = queue.poll();

                for (int i=0;i<4;i++){
                    int new_x = curr[0]+direction[i][0];
                    int new_y = curr[1]+direction[i][1];
                    if (new_x>=0 && new_x<m && new_y>=0 && new_y<n && !visited[new_x][new_y] && grid[new_x][new_y]==1){
                        visited[new_x][new_y]=true;
                        freshCount--;
                        queue.add(new int[]{new_x,new_y});
                    }
                }

            }
            ans++;
            if (freshCount==0){
                return ans;
            }

            if (prevFresh==freshCount){
                return -1;
            }
        }

        return -1;
    }

}
