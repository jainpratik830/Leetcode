package Google.April;

import java.util.Arrays;

public class Largest_Submatrix_With_Rearrangements {

//    T = O(mnlogn)
//    S = O(n)
    public int largestSubmatrix(int[][] matrix) {
        for(int i=1;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==1){
                    matrix[i][j]= matrix[i-1][j]+1;
                }
            }
        }

        int ans =0;

        for(int[] arr: matrix){
            Arrays.sort(arr);
            for(int j=1;j<=matrix[0].length;j++){
                ans = Math.max(ans, j*arr[matrix[0].length-j]);
            }
        }
        return ans;
    }

}
