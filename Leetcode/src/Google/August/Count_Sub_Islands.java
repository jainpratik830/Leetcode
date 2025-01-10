package Google.August;

import java.util.LinkedList;
import java.util.Queue;

public class Count_Sub_Islands {

    int[][] direction = {{0,1},{1,0},{0,-1},{-1,0}};

    public void bfs(int[][] grid,boolean[][] visited,int x,int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y]=true;
        while (!queue.isEmpty()){
            int[] curr = queue.poll();

            for (int i=0;i<4;i++){
                int new_x = curr[0]+direction[i][0];
                int new_y = curr[1]+direction[i][1];
                if (new_x>=0 && new_x<grid.length && new_y>=0 && new_y<grid[0].length && !visited[new_x][new_y] && grid[new_x][new_y]==1){
                    visited[new_x][new_y]=true;
                    queue.add(new int[]{new_x,new_y});
                }
            }
        }
    }

    public boolean bfs2(int[][] grid,boolean[][] visited1,boolean[][] visited2,int x,int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        boolean flag =true;
        visited2[x][y]=true;
        while (!queue.isEmpty()){
            int[] curr = queue.poll();

            for (int i=0;i<4;i++){
                int new_x = curr[0]+direction[i][0];
                int new_y = curr[1]+direction[i][1];
                if (new_x>=0 && new_x<grid.length && new_y>=0 && new_y<grid[0].length && !visited2[new_x][new_y] && grid[new_x][new_y]==1){
                    visited2[new_x][new_y]=true;
                    if (!visited1[new_x][new_y]){
                        flag=false;
                    }
                    queue.add(new int[]{new_x,new_y});
                }
            }
        }

        return flag;
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {


        int m = grid1.length;
        int n = grid1[0].length;

        boolean[][] visited= new boolean[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (grid1[i][j]==1 && !visited[i][j]){
                    bfs(grid1,visited,i,j);
                }
            }
        }

        boolean[][] visited2= new boolean[m][n];

        int count =0;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (grid2[i][j]==1 && grid1[i][j]==1 && !visited2[i][j]){
                    if (bfs2(grid2,visited,visited2,i,j)){
                        count++;
                    }
                }
            }
        }

        return count;
    }

}
