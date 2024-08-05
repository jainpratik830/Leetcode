package Google.August;

import java.util.LinkedList;
import java.util.Queue;

public class Zero1_Matrix {

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;;
        int n = mat[0].length;
        int[][] ans = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (mat[i][j]==0){
                    visited[i][j]=true;
                    queue.add(new int[]{i,j,0});
                }
            }
        }
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        while (!queue.isEmpty()){
            int[] curr = queue.poll();
            ans[curr[0]][curr[1]]=curr[2];

            for (int i=0;i<4;i++){
                int new_x = curr[0]+dir[i][0];
                int new_y = curr[1]+dir[i][1];
                if (new_x>=0 && new_x<m && new_y>=0 && new_y<n && !visited[new_x][new_y]){
                    visited[new_x][new_y]=true;
                    queue.add(new int[]{new_x,new_y,curr[2]+1});
                }
            }

        }

        return ans;
    }

}
