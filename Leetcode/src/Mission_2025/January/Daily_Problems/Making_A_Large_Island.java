package Mission_2025.January.Daily_Problems;

import java.util.*;

public class Making_A_Large_Island {

    public int largestIsland(int[][] grid) {
        int id =2;
        int ans =1;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]==1){
                    int size = bfs(grid,id,i,j);
                    map.put(id,size);
                    ans = Math.max(ans,size);
                    id++;
                }
            }
        }
        for (int[] a:grid){
            System.out.println(Arrays.toString(a));
        }
        int[][] directions = {{0,1},{-1,0},{1,0},{0,-1}};
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]==0){
                    Set<Integer> neighbour = new HashSet<>();
                    for (int k=0;k<4;k++){
                        int x = i+directions[k][0];
                        int y = j+directions[k][1];
                        if (x>=0 && x<grid.length && y>=0 && y<grid[0].length && grid[x][y]!=0)  {
                            neighbour.add(grid[x][y]);
                        }
                    }
                    if (neighbour.size()>0){
                        int curr= 1;
                        for (int k:neighbour){
                            curr+= map.get(k);
                        }
                        ans =Math.max(ans,curr);
                    }
                }
            }
        }
        return ans;
    }

    public int bfs(int[][] grid,int id,int i,int j){
        Queue<int[]> queue= new LinkedList<>();
        int[][] directions = {{0,1},{-1,0},{1,0},{0,-1}};
        queue.add(new int[]{i,j});
        int size= 0;
        while (!queue.isEmpty()){
            int[] curr = queue.poll();
            size++;
            grid[curr[0]][curr[1]]=id;
            for (int k=0;k<4;k++){
                int x = curr[0]+directions[k][0];
                int y = curr[1]+directions[k][1];
                if (x>=0 && x<grid.length && y>=0 && y<grid[0].length && grid[x][y]==1)  {
                    grid[x][y]= id;
                    queue.add(new int[]{x,y});
                }
            }

        }
        return size;


    }
}
