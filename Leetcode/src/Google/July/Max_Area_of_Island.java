package Google.July;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Max_Area_of_Island {

    int[] X = new int[]{-1,1,0,0};
    int[] Y = new int[]{0,0,-1,1};


    public int maxAreaOfIsland(int[][] grid) {
        int ans =0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]==1 && !visited[i][j]){
                    ans = Math.max(ans,dfs(i,j,grid,visited));
                }
            }
        }



        return ans;
    }

    public int dfs(int x,int y,int[][] grid,boolean[][] visited){
        if (visited[x][y]){
            return 0;
        }
        int ans =1;
        visited[x][y]=true;
        for (int i=0;i<4;i++){
            int new_x = x+X[i];
            int new_y = y+Y[i];
            if (new_x>=0 && new_x<grid.length && new_y>=0 && new_y<grid[0].length && grid[new_x][new_y]==1 && !visited[new_x][new_y]){
                // visited[new_x][new_y]=true;
                ans +=dfs(new_x,new_y,grid,visited);

            }
        }

        return ans;
    }

    public int bfs(int x,int y,int[][] grid,boolean[][] visited){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        int ans =0;
        visited[x][y]=true;
        while (!queue.isEmpty()){
            int[] curr = queue.poll();
            ans++;
            for (int i=0;i<4;i++){
                int new_x = curr[0]+X[i];
                int new_y = curr[1]+Y[i];
                if (new_x>=0 && new_x<grid.length && new_y>=0 && new_y<grid[0].length && grid[new_x][new_y]==1 && !visited[new_x][new_y]){
                    visited[new_x][new_y]=true;
                    queue.add(new int[]{new_x,new_y});

                }
            }

        }

        return ans;

    }


}
