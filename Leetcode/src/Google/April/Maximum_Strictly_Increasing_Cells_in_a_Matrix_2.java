package Google.April;

import java.util.*;

public class Maximum_Strictly_Increasing_Cells_in_a_Matrix_2 {

    // TIME Complexity = O(M*N)
    // SPACE Complexity = o(M*N)

    public int maxIncreasingCells(int[][] mat) {
        int ans = Integer.MIN_VALUE;
        int[][] temp = new int[mat.length][mat[0].length];
        int[] rowMax = new int[mat.length];
        int[] colMax = new int[mat[0].length];
        Map<Integer, List<int[]>> map = new HashMap<>();
        Set<Integer> values = new TreeSet<>();

        for (int i=0;i<mat.length;i++){
            for (int j=0;j<mat[0].length;j++){
                int val = -mat[i][j];
                if (!map.containsKey(val)){
                    map.put(val,new ArrayList<>());
                }
                int[] curr = new int[]{i,j};
                map.get(val).add(curr);
                values.add(val);
            }
        }

        for (int i: values){
            for (int[] position:map.get(i)){
                int x = position[0];
                int y = position[1];
                temp[x][y] = 1+ Math.max(rowMax[x],colMax[y]);
            }
            for (int[] position:map.get(i)){
                int x = position[0];
                int y = position[1];
                rowMax[x] = Math.max(rowMax[x],temp[x][y]);
                colMax[y] = Math.max(colMax[y],temp[x][y]);
            }
        }

        for (int i:rowMax){
            ans = Math.max(i,ans);
        }

        for (int j:colMax){
            ans = Math.max(ans,j);
        }



        return ans;
    }


}
