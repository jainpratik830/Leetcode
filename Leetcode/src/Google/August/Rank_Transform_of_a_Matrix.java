package Google.August;

import java.util.*;

public class Rank_Transform_of_a_Matrix {

    public int[][] matrixRankTransform(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] ans  =new int[m][n];
        int[] row = new int[m];
        int[] col = new int[n];
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();

        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                map.putIfAbsent(matrix[i][j],new ArrayList<>());
                map.get(matrix[i][j]).add(new int[]{i,j});
            }
        }

        for (int i:map.keySet()){
            List<int[]> curr = map.get(i);
            int currRank =0;
            for (int[] j:curr){
                currRank=Math.max(currRank, Math.max(row[j[0]],col[j[1]]));
            }
            currRank++;
            for (int[] j:curr){
                ans[j[0]][j[1]]=currRank;
                row[j[0]]=currRank;
                col[j[1]]=currRank;
            }
            System.out.println("Row Col");
            System.out.println(Arrays.toString(row));
            System.out.println(Arrays.toString(col));
        }

        return ans;
    }

}
