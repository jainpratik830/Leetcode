package Google.July;

import java.util.ArrayList;

public class Largest_Submatrix_With_Rearrangements {

    public int largestSubmatrix(int[][] matrix) {
        int ans =0;

        ArrayList<int[]> list = new ArrayList<>();
        for (int i=0;i<matrix.length;i++){
            ArrayList<int[]> list2 = new ArrayList<>();
            boolean[] seen = new boolean[matrix[0].length];
            for (int[] j:list){

                if (matrix[i][j[1]]==1){
                    list2.add(new int[]{j[0]+1,j[1]});
                    seen[j[1]]=true;
                }

            }

            for (int j=0;j<matrix[0].length;j++){
                if (!seen[j] && matrix[i][j]==1){
                    list2.add(new int[]{1,j});
                }
            }

            for (int j=0;j<list2.size();j++){
                ans = Math.max(ans, (j+1)*list2.get(j)[0] );
            }

            list = list2;

        }

        return ans;
    }

}
