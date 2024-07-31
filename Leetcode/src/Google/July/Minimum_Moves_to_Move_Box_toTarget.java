package Google.July;

import java.util.LinkedList;
import java.util.Queue;

public class Minimum_Moves_to_Move_Box_toTarget {

    int m,n;
    private int[] dir = new int[]{-1,0,1,0,-1};

    public int minPushBox(char[][] grid) {
        m= grid.length;
        n = grid[0].length;
        int[] p = new int[2];
        int[] t = new int[2];
        int[] b = new int[2];
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<n;j++){
                if (grid[i][j]=='S'){
                    p = new int[]{i,j};
                }
                if (grid[i][j]=='T'){
                    t = new int[]{i,j};
                }
                if (grid[i][j]=='B'){
                    b = new int[]{i,j};
                }
                if (grid[i][j]!='#'){
                    grid[i][j]='.';
                }
            }
        }
        return helper(p,b,t,grid);

    }

    private boolean inBound(int r, int c) {
        return r >= 0 && c >= 0 && r < m && c < n;
    }

    public boolean reachable(int x,int y,int tx,int ty,char[][] grid){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        boolean[][] visited= new boolean[m][n];
        int step=0;
        if(x ==tx && y == ty)
            return true;
        while (!queue.isEmpty()){
            int[] curr = queue.poll();
            for (int i=0;i<4;i++){
                int newRow = curr[0]+dir[i];
                int newCol = curr[1]+dir[i+1];
                if (inBound(newRow,newCol) && !visited[newRow][newCol] && grid[newRow][newCol]!='#' ){
                    queue.add(new int[]{newRow,newCol});
                    if(tx == newRow && ty == newCol)  return true;
                    visited[newRow][newCol]=true;
                }
            }
        }
        return false;
    }

    public int helper(int[] p,int[] b,int[] t,char[][] grid){

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{b[0],b[1],p[0],p[1]});
        boolean[][][] visited= new boolean[m][n][4];
        int step=0;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-->0){
                int[] curr = queue.poll();
                grid[curr[0]][curr[1]]='#';
                for (int i=0;i<4;i++){
                    int newRow = curr[0]+dir[i];
                    int newCol = curr[1]+dir[i+1];
                    if (inBound(newRow,newCol) && !visited[newRow][newCol][i] && grid[newRow][newCol]!='#' && reachable(curr[2],curr[3],curr[0]-dir[i],curr[1]-dir[i+1],grid)){
                        queue.add(new int[]{newRow,newCol,curr[0],curr[1]});
                        if(t[0] == newRow && t[1] == newCol)  return step+1;
                        visited[newRow][newCol][i]=true;
                    }
                }
                grid[curr[0]][curr[1]]='.';
            }
            step++;
        }
        return -1;
    }

}
