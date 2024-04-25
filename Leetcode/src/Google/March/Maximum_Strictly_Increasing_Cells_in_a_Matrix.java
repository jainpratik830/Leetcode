package Google.March;

import java.util.*;

public class Maximum_Strictly_Increasing_Cells_in_a_Matrix {
    int m,n;
    int[][] dp;
    boolean[][] visited;
    TreeMap<Integer,List<Integer>> mpRow[];
    TreeMap<Integer,List<Integer>> mpCol[];
    HashMap<String, List<Integer>> row_map,col_map;
    public int maxIncreasingCells(int[][] mat) {
        int ans = 0;
        m = mat.length;
        n = mat[0].length;
        dp = new int[m][n];
        mpRow = new TreeMap[m];
        mpCol = new TreeMap[n];
        for(int i = 0;i < m;i++){
            mpRow[i] = new TreeMap<>();
            for(int j = 0;j < n;j++){
                if(!mpRow[i].containsKey(mat[i][j])){
                    mpRow[i].put(mat[i][j],new ArrayList<>());
                }
                mpRow[i].get(mat[i][j]).add(j);
            }
        }
        for(int j = 0;j < n;j++){
            mpCol[j] = new TreeMap<>();
            for(int i = 0;i < m;i++){
                if(!mpCol[j].containsKey(mat[i][j])){
                    mpCol[j].put(mat[i][j],new ArrayList<>());
                }
                mpCol[j].get(mat[i][j]).add(i);
            }
        }
        visited= new boolean[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (dp[i][j]==0){
                    dfs(i,j,mat);
                }

                int curr= dp[i][j];
                ans = Math.max(ans,curr);
            }
            // System.out.println(Arrays.toString(dp[i]));
        }

        return ans;
    }

    public int dfs(int i,int j,int[][] mat){

        if (dp[i][j]!=0 ){
            return dp[i][j];
        }
        visited[i][j] =true;
        int curr=1;
        Map.Entry<Integer,List<Integer>> key = mpRow[i].higherEntry(mat[i][j]);
        if (key!=null) {
            for (int k :key.getValue()) {
                if(!visited[i][k]){
                    curr = Math.max(curr, 1 + dfs(i, k, mat));
                     break;
                }
            }
        }
        Map.Entry<Integer,List<Integer>> colKey = mpCol[j].higherEntry(mat[i][j]);
        if (colKey!=null) {
            for (int k :colKey.getValue()) {
                // if (k != i && mat[k][j] > mat[i][j]) {
                if(!visited[k][j]){
                    curr = Math.max(curr, 1 + dfs(k,j,mat));
                     break;
                }
            }
        }

        visited[i][j] =false;
        return dp[i][j]=curr;
    }

}
