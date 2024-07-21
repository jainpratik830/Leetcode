package Google.July;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Shortest_Path_with_Obstacles_Elimination {

    public int shortestPath(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;
        int[] x= {0,0,-1,1};
        int[] y = {-1,1,0,0};

        Queue<int[]> queue= new LinkedList<>();
        Set<String> visited = new HashSet<>();

        if (k>=m+n-2){
            return m+n-2;
        }
//        0-Steps,1-row,2-col,3-k_value
        queue.add(new int[]{0,0,0,k});
        visited.add("0,0,"+k);

        while (!queue.isEmpty()){
            int[] curr = queue.poll();

            if (curr[1]==m-1 && curr[2]==n-1){
                return curr[0];
            }

            for (int i=0;i<4;i++){
                int new_x = curr[1]+x[i];
                int new_y= curr[2]+y[i];
                int new_k=curr[3];
                if (Math.min(new_x,new_y)>=0 && new_y<n && new_x<m){
                    if (grid[new_x][new_y]==1){
                        new_k--;
                    }
                    if (new_k>=0 && !visited.contains(new_x+","+new_y+","+new_k)){
                        queue.add(new int[]{curr[0]+1,new_x,new_y,new_k});
                        visited.add(new_x+","+new_y+","+new_k);
                    }
                }
            }

        }

        return -1;
    }

}
