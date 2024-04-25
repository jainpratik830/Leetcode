package Google.April;

import java.util.ArrayList;

public class Find_All_Groups_of_Farmland {

    boolean[][] visited;
    int m,n;
    int[] x = {0,0,1,-1};
    int[] y = {-1,1,0,0};

    public boolean isEnd(int i,int j,int[][] land){
        if (((i==m-1) || (i+1<m && land[i+1][j]==0)) && ((j==n-1) || (j+1<n && land[i][j+1]==0)) && !visited[i][j]){
            return true;
        }
        return false;
    }

    public void dfs(int i,int j,ArrayList<int[]> arr,int[][] land){

        if (isEnd(i,j,land)){
            arr.get(arr.size()-1)[2]=i;
            arr.get(arr.size()-1)[3]=j;
            visited[i][j]=true;

            return;
        }

        visited[i][j]=true;

        for (int k=0;k<4;k++){
            int curr_x = i+x[k];
            int curr_y = j+y[k];
            if (curr_y>=0 && curr_x>=0 && curr_x<m && curr_y < n && !visited[curr_x][curr_y] && land[curr_x][curr_y]==1){
                dfs(curr_x,curr_y,arr,land);
            }
        }


    }


    public int[][] findFarmland(int[][] land) {
        ArrayList<int[]> arr=  new ArrayList<>();
        m= land.length;;
        n = land[0].length;

        visited = new boolean[m][n];

        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (land[i][j]==1 && !visited[i][j]){
                    arr.add(new int[]{i,j,0,0});
                    dfs(i,j,arr,land);
                }
            }
        }

        int[][] ans = new int[arr.size()][4];
        for (int i=0;i<arr.size();i++){
            ans[i] = arr.get(i);
        }
        return ans;

    }


}
