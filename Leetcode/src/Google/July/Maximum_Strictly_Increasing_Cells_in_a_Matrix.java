package Google.July;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class Maximum_Strictly_Increasing_Cells_in_a_Matrix {

    public int maxIncreasingCells(int[][] mat) {
        int m =mat.length;
        int n = mat[0].length;

        HashMap<Integer, List<int[]>> map = new HashMap<>();
        TreeSet<Integer> treeSet= new TreeSet<>();
        int[][] dp = new int[m][n];
        int[] rowMax =  new int[m];
        int[] colMax = new int[n];

        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                map.putIfAbsent(mat[i][j],new ArrayList<>());
                map.get(mat[i][j]).add(new int[]{i,j});
                treeSet.add(mat[i][j]);
            }
        }
        int ans =0;
        for (int val:treeSet){

            for (int[] i:map.get(val)){
                int x= i[0];
                int y = i[1];

                dp[x][y]= Math.max(colMax[y],rowMax[x])+1;
                ans =Math.max(ans,dp[x][y]);
            }

            for (int[] i:map.get(val)){
                int x= i[0];
                int y = i[1];

                rowMax[x]= Math.max(dp[x][y],rowMax[x]);
                colMax[y]= Math.max(dp[x][y],colMax[y]);
            }

        }


        return ans;
    }
}
