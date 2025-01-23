package Mission_2025.January.Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class Surrounded_Regions {

    public void solve(char[][] board) {
        int[][] directions = {{0,1},{-1,0},{1,0},{0,-1}};
        Queue<int[]> queue = new LinkedList<>();
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (board[i][j]=='0' && (i==0 || i== n-1 || j==0 || j==m-1) ){
                    queue.add(new int[]{i,j});
                    visited[i][j]=true;
                }
            }
        }

        while (!queue.isEmpty()){
            int[] curr = queue.poll();
            for (int k=0;k<4;k++){
                int x = curr[0]+directions[k][0];
                int y = curr[1]+directions[k][1];
                if (x>=0 && x<n && y>=0 && y<m && board[x][y]=='O' && !visited[x][y])  {
                    board[x][y]= 'O';
                    visited[x][y]=true;
                    queue.add(new int[]{x,y});
                }
            }

        }

        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (!visited[i][j] &&  board[i][j]== '0'){
                    board[i][j]= 'X';
                }
            }
        }
    }


}
