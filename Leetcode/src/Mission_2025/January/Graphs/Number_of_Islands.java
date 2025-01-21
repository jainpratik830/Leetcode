package Mission_2025.January.Graphs;

public class Number_of_Islands {

    int[] x = {0,0,-1,1};
    int[] y= {-1,1,0,0};

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited= new boolean[n][m];
        int ans =0;
        for (int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if (grid[i][j]=='1' && !visited[i][j]){
                    ans++;
                    dfs(i,j,grid,visited);
                }
            }
        }
        return ans;

    }
    public boolean isValid(int i,int j,char[][] grid,boolean[][] visited){

        if (Math.min(i,0)>=0 && Math.min(j,0)>=0 && i<grid.length && j < grid[0].length && grid[i][j]=='1' && !visited[i][j]){
            return true;
        }

        return false;

    }

    public void dfs(int i,int j,char[][] grid,boolean[][] visited){

        visited[i][j]=true;

        for (int k=0;k<4;k++){
            if (isValid(i+x[k],j+y[k],grid,visited)){
                dfs(i+x[k],j+y[k],grid,visited);
            }
        }

    }


}
