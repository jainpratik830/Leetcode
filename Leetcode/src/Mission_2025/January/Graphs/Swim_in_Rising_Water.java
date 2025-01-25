package Mission_2025.January.Graphs;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Swim_in_Rising_Water {

    public int swimInWater(int[][] grid) {
        int ans =0;
        int m = grid.length;
        int n = grid[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(i->i[2]));
        pq.add(new int[]{0,0,grid[0][0]});
        int[][] directions = {{0,1},{-1,0},{1,0},{0,-1}};
        boolean[][] visited = new boolean[m][n];
        while (!pq.isEmpty()){
            int[] curr= pq.poll();
            if (curr[0]== m-1 && curr[1]==n-1){
                return curr[2];
            }
             if (visited[curr[0]][curr[1]]){
                 continue;
             }
            visited[curr[0]][curr[1]]=true;
            for (int k=0;k<4;k++){
                int x = curr[0]+directions[k][0];
                int y = curr[1]+directions[k][1];
                if (x>=0 && x<m && y>=0 && y<n && !(visited[x][y]))  {
                    pq.add(new int[]{x,y,Math.max(curr[2],grid[x][y])});
                }
            }
        }
        return ans;

    }

}
