package Google.July;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Minimum_Falling_Path_Sum_II {

    class Server {
        int finishTime;
        int processingTime;

        Server(int processingTime) {
            this.finishTime = 0;
            this.processingTime = processingTime;
        }

        public int compare(Server o1, Server o2) {
            return 0;
        }
    }

    public int minFallingPathSum(int[][] grid) {
        int ans =Integer.MAX_VALUE;



        for (int i=1;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                int min = Integer.MAX_VALUE;

                for (int k=0;k<grid[0].length;k++){
                    if (k==j){
                        continue;
                    }
                    min= Math.min(min,grid[i][k]);
                }
                grid[i][j]=grid[i-1][j]+min;

            }
        }



        for (int i:grid[grid.length-1]){

            ans= Math.min(ans,i);
        }

        return ans;
    }

}
