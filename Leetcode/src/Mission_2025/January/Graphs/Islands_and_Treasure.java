package Mission_2025.January.Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class Islands_and_Treasure {

    public void islandsAndTreasure(int[][] grid) {
        int[][] directions = {{0,1},{-1,0},{1,0},{0,-1}};
        Queue<int[]> queue = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (grid[i][j]==0){
                    queue.add(new int[]{i,j,0});
                }
            }
        }

        while (!queue.isEmpty()){
            int[] curr = queue.poll();
            if (visited[curr[0]][curr[1]]){
                continue;
            }else {
                visited[curr[0]][curr[1]]=true;
                for (int k=0;k<4;k++){
                    int x = curr[0]+directions[k][0];
                    int y = curr[1]+directions[k][1];
                    if (x>=0 && x<n && y>=0 && y<m && grid[x][y]!=-1 && (grid[x][y]>curr[2]))  {
                        grid[x][y]= curr[2]+1;
                        queue.add(new int[]{x,y,grid[x][y]});
                    }
                }
            }
        }

    }

}
