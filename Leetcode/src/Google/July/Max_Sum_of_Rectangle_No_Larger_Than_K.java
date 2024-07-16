package Google.July;

import java.util.Arrays;
import java.util.TreeSet;

public class Max_Sum_of_Rectangle_No_Larger_Than_K {
    int result;

    public void updateResult(int[] arr,int k){
        int sum =0;
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(0);
        for (int i:arr){
            sum+=i;
            Integer x = treeSet.ceiling(sum-k);
            if (x!=null){
                result = Math.max(result,sum-x);
            }

            treeSet.add(sum);
        }
    }

    public int maxSumSubmatrix(int[][] matrix, int k) {
        result=Integer.MIN_VALUE;

        int[] rowSum = new int[matrix[0].length];
        for (int i=0;i<matrix.length;i++){
            Arrays.fill(rowSum,0);

            for (int row = i;row<matrix.length;row++) {
                for (int col = 0; col < matrix[0].length; col++) {
                    rowSum[col]+=matrix[row][col];

                }

                updateResult(rowSum,k);
                if (result==k){
                    return result;
                }
            }
        }


        return result;
    }

}
