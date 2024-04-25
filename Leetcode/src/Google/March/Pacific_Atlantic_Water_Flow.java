package Google.March;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pacific_Atlantic_Water_Flow {

    Integer[][] dp_p;
    Integer[][] dp_a;
    int m;
    int n;

    public boolean isValid(int i,int j){
        if (i>=0 & i<m && j>=0 && j<n){
            return true;
        }
        return false;
    }

    public int dfs_p(int i,int j,int[][] heights,boolean[][] visited,int type,Integer[][] dp){
        if (type==0 && (i==0 || j==0)){
            return 1;
        }
        if (type==1 && (i==m-1 || j==n-1)){
            return 1;
        }
//        if (visited[i][j]){
//            return dp[i][j];
//        }
        visited[i][j]=true;
//        if (dp[i][j]!=null){
//            return dp[i][j];
//        }

        int[] x= {0,0,1,-1};
        int[] y = {1,-1,0,0};

        for (int k=0;k<4;k++){
            if ( isValid(i+x[k],j+y[k]) && !visited[i+x[k]][j+y[k]] && heights[i+x[k]][j+y[k]]<=heights[i][j]){
                if (dfs_p(i+x[k],j+y[k],heights,visited,type,dp)==1) {
//                    dp[i][j] = 1;
//                    break;
                    return 1;
                }
            }
        }
//        if (dp[i][j]==null){
//            dp[i][j]=0;
//        }
//        return dp[i][j];
        return 0;
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;

        n = heights[0].length;
        dp_p = new Integer[m][n];
        dp_a = new Integer[m][n];
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if(i==0 || j==0){
                    dp_p[i][j]=1;
                }else{
                    boolean[][] visited = new boolean[m][n];
                    if (i==1 && j==4){
                        for (Integer[] a:dp_p){
                            System.out.println(Arrays.toString(a));
                        }
                    }
                    if (dp_p[i][j]==null){
                        dp_p[i][j]= dfs_p(i,j,heights,visited,0,dp_p);
                    }

                }

                if(i==m-1 || j==n-1){
                    dp_a[i][j]=1;
                }else{
                    boolean[][] visited = new boolean[m][n];
                    if (dp_a[i][j]==null){
                        dp_a[i][j]= dfs_p(i,j,heights,visited,1,dp_a);
                    }

                }

            }
        }
        for(int i=0;i<m;i++) {
            for (int j = 0; j < n; j++) {
                if (dp_p[i][j]==1 && dp_a[i][j]==1){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    ans.add(list);
                }

            }
        }
        System.out.println(ans);
        for (Integer[] a:dp_p){
            System.out.println(Arrays.toString(a));
        }
        System.out.println("==========");
        for (Integer[] a:dp_a){
            System.out.println(Arrays.toString(a));
        }

        return ans;
    }

}
