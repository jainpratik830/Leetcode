package Google.July;

import java.util.ArrayList;
import java.util.List;

public class Spiral_Matrix {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> ans = new ArrayList<>();
        int m = matrix.length;
        int n= matrix[0].length;
        int top = 0;
        int bottom = m-1;
        int left = 0;
        int right = n-1;

        while (ans.size()<m*n){

            for (int i=left;i<=right;i++){
                ans.add(matrix[top][i]);
            }

            for (int i=top;i<=bottom;i++){
                ans.add(matrix[i][right]);
            }
            if (top != bottom) {
                for (int i = right; i > left; i--) {
                    ans.add(matrix[bottom][i]);
                }
            }

            if (left != right) {
                for (int i = bottom; i > top; i--) {
                    ans.add(matrix[i][left]);
                }

            }
            left++;
            right--;
            top++;
            bottom--;

        }


        return ans;

    }
}
