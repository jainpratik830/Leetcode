package Google.April;

import java.util.LinkedList;
import java.util.Queue;

public class Number_of_Closed_Islands {


    int m,n;

    int[] a={0,0,-1,1};
    int[] b = {-1,1,0,0};
    boolean[][] visited;
    public int closedIsland(int[][] grid) {
        int ans =0;
         m = grid.length;
         n = grid[0].length;
         visited= new boolean[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){

                if (i == 0 || j == 0 || i==m-1 || j==n-1) {
                    if (grid[i][j]==0){
                        grid[i][j]=-1;
                    }
                    continue;
                }
                if (grid[i][j] ==0 && !visited[i][j]){
//                    ans++;
                    if (bfs(i,j,grid)){
                        ans++;
                    }

//                    for (boolean[] x:visited){
//                        System.out.println(Arrays.toString(x));
//                    }
                }

            }
        }


        return ans;
    }

    public boolean bfs(int i,int j,int[][] grid){
        boolean isIsland = true;
        Queue<int[]> queue= new LinkedList<>();
        queue.add(new int[]{i,j});
//        System.out.println("i="+i+" j="+j);
        while (!queue.isEmpty()){
            int[] curr = queue.poll();
            visited[curr[0]][curr[1]]=true;

            for (int k=0;k<4;k++){
                int curr_x = curr[0]+a[k];
                int curr_y = curr[1]+b[k];
                if (curr_y>=0 && curr_x>=0 && curr_x<m && curr_y < n && !visited[curr_x][curr_y]){
                   if (grid[curr_x][curr_y]==0) {
                       queue.add(new int[]{curr_x, curr_y});
                   }else if (grid[curr_x][curr_y]==-1) {
                       isIsland=false;
                   }

                }
            }
        }
        return isIsland;

    }

}
