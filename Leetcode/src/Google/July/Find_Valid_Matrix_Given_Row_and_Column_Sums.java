package Google.July;

public class Find_Valid_Matrix_Given_Row_and_Column_Sums {

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n =colSum.length;

        int[][] ans = new int[m][n];

        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                ans[i][j]= Math.min(rowSum[i],colSum[j]);
                rowSum[i]-= ans[i][j];
                colSum[j]-=ans[i][j];
            }
        }

        return ans;

    }

}
