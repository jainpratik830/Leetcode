package Google.April;

import java.util.LinkedList;
import java.util.Queue;

public class Shortest_Path_in_Binary_Matrix {

    public int shortestPathBinaryMatrix(int[][] grid) {
        int ans =0;

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();

        if (grid[0][0]==1 || grid[grid.length-1][grid[0].length-1]==1){
            return -1;
        }

        queue.add(new int[]{0,0,1});
        visited[0][0]=true;
        int[][] directions = {{-1,-1},{1,1},{1,0},{0,1},{-1,0},{0,-1},{-1,1},{1,-1}};

        while (!queue.isEmpty()){
            int[] curr = queue.poll();

            if (curr[0]== grid.length-1 && curr[1] == grid[0].length-1){
                return curr[2];
            }


            for (int[] i:directions){

                if (i[0]+curr[0]>=0 && i[0]+curr[0]< grid.length &&
                        i[1]+curr[1]>=0 && i[1]+curr[1]< grid[0].length &&
                !visited[i[0]+curr[0]][i[1]+curr[1]] && grid[i[0]+curr[0]][i[1]+curr[1]]==0){
                    visited[i[0]+curr[0]][i[1]+curr[1]]=true;
                    queue.add(new int[]{i[0]+curr[0],i[1]+curr[1],curr[2]+1});
                }
            }

        }


        return -1;
    }

}
