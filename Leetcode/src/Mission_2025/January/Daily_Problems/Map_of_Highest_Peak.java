package Mission_2025.January.Daily_Problems;

import java.util.LinkedList;
import java.util.Queue;

public class Map_of_Highest_Peak {

    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] ans = new int[m][n];
        Queue<int[]> queue=  new LinkedList<>();
        int[][] directions = {{0,1},{-1,0},{1,0},{0,-1}};
        boolean[][] visited = new boolean[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (isWater[i][j]==1){
                    queue.add(new int[]{i,j,0});
                    isWater[i][j]=0;
                }else {
                    isWater[i][j]=1;
                }
            }
        }
        int count =0;
        while (!queue.isEmpty()){
            int size= queue.size();
            for (int i=0;i<size;i++){
                int[] curr= queue.poll();
                ans[curr[0]][curr[1]]=count;
                // if (visited[curr[0]][curr[1]]){
                //     continue;
                // }
                visited[curr[0]][curr[1]]=true;
                for (int k=0;k<4;k++){
                    int x = curr[0]+directions[k][0];
                    int y = curr[1]+directions[k][1];
                    if (x>=0 && x<m && y>=0 && y<n && isWater[x][y]==1 && !(visited[x][y]))  {
                        visited[x][y]=true;
                        queue.add(new int[]{x,y,isWater[x][y]});
                    }
                }
            }
            count++;
        }
        return ans;
    }

}
