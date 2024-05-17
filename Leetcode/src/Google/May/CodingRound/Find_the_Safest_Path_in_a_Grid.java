package Google.May.CodingRound;

import java.util.*;

public class Find_the_Safest_Path_in_a_Grid {



    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int ans =0;
        int m =grid.size();
        int n = grid.get(0).size();
        int[][] mat = new int[m][n];
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

        Queue<int[]> queue = new LinkedList<>();
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (grid.get(i).get(j)==1){
                    queue.add(new int[]{0,i,j});
                }
            }
        }
        boolean[][] visited = new boolean[m][n];
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-->0){
                int[] curr = queue.poll();
                if(visited[curr[1]][curr[2]]){
                    continue;
                }
                mat[curr[1]][curr[2]]=curr[0];
                visited[curr[1]][curr[2]]=true;
                for (int i=0;i<4;i++){
                    int new_x = curr[1]+dir[i][0];
                    int new_y = curr[2]+dir[i][1];
                    if (new_x>=0 && new_x<m && new_y>=0 && new_y<n && !visited[new_x][new_y]){
                        queue.add(new int[]{curr[0]+1,new_x,new_y});
                    }
                }
            }
        }
        // for (int[] i: mat)
        //     System.out.println(Arrays.toString(i));

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->-a[0]));
        pq.add(new int[]{mat[0][0],0,0});
        visited = new boolean[m][n];
        while (!pq.isEmpty()){
            int[] curr = pq.poll();
            if (curr[1]==m-1 && curr[2]==n-1){
                return curr[0];
            }
            if(visited[curr[1]][curr[2]]){
                continue;
            }
            visited[curr[1]][curr[2]]=true;
            for (int i=0;i<4;i++){
                int new_x = curr[1]+dir[i][0];
                int new_y = curr[2]+dir[i][1];
                if (new_x>=0 && new_x<m && new_y>=0 && new_y<n && !visited[new_x][new_y]){
                    pq.add(new int[]{Math.min(curr[0],mat[new_x][new_y]),new_x,new_y});
                }
            }


        }


        return ans;
    }



}
