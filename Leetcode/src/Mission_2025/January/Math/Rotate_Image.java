package Mission_2025.January.Math;

import java.util.Arrays;

public class Rotate_Image {

    public void rotate(int[][] matrix) {

        int n = matrix.length;
        for (int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }

        for (int[] i:matrix){
            System.out.println(Arrays.toString(i));
        }

        for (int i=0;i<n;i++){

            for (int j=0;j<n/2;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }

    }

}
