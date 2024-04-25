package Google.April;

public class Unique_Paths_III {

    int m,n,count;

    int[] a={0,0,-1,1};
    int[] b = {-1,1,0,0};

    public int dfs(int x,int y,int[][] grid,boolean[][] visited,int curr_count){
        if (grid[x][y]==2){
            System.out.println(curr_count);
            if (curr_count==count){
                return 1;
            }
            return 0;
        }
        visited[x][y]=true;
        int ans =0;
        for (int i=0;i<4;i++){
            int new_x = x+a[i];
            int new_y= y+b[i];
            if (new_x>=0 && new_x<m && new_y>=0 && new_y<n && !visited[new_x][new_y] && grid[new_x][new_y]==0){
                ans += dfs(new_x,new_y,grid,visited,curr_count+1);
            }
        }
        return ans;
    }

    public int uniquePathsIII(int[][] grid) {
        count=0;
        m= grid.length;
        n= grid[0].length;
        int[] start= new int[2];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (grid[i][j]==0){
                    count++;
                }
                if (grid[i][j]==1){
                    start= new int[]{i,j};
                }
            }
        }

        return dfs(start[0],start[1],grid,new boolean[m][n],0);
    }


}
