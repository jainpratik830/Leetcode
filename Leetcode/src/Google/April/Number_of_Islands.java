package Google.April;

import java.util.LinkedList;
import java.util.Queue;

public class Number_of_Islands {


    boolean[][] visited;
    int[] x= {0,0,1,-1};
    int[] y = {-1,1,0,0};
    int m,n;

    public int numIslands(char[][] grid) {
        m=grid.length;
        n=grid[0].length;
        visited = new boolean[m][n];
        int ans =0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    bfs(grid,i,j);
                    ans++;
                }
            }
        }

        return ans;

    }

    public void bfs(char[][] grid,int i,int j){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,j});

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            if(visited[curr[0]][curr[1]]){
                continue;
            }
            visited[curr[0]][curr[1]]=true;
            for(int k=0;k<4;k++){
                int new_x = curr[0]+x[k];
                int new_y = curr[1]+y[k];
                if(new_x>=0 && new_x<m && new_y>=0 && new_y <n && grid[new_x][new_y]=='1' && !visited[new_x][new_y]){
                    queue.add(new int[]{new_x,new_y});
                }
            }

        }


    }

}
