package Google.July;

import java.util.Arrays;

public class Maximum_Number_of_Accepted_Invitations {

    public int maximumInvitations(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] match = new int[n];
        int count =0;
        Arrays.fill(match,-1);
        for (int i=0;i<m;i++){
            boolean[] visited =new boolean[n];
            if (helper(i,grid,visited,match)){
                count++;
            }
        }

        return count;
    }

    public boolean helper(int i,int[][] grid,boolean[] visited,int[] match){

        for (int j=0;j<grid[0].length;j++){
            if (grid[i][j]==1 && !visited[j]){
                visited[j]=true;
                if (match[j]== -1 || helper(match[j],grid,visited,match)){
                    match[j]=i;
                    return true;
                }
            }
        }
        return false;

    }

}
