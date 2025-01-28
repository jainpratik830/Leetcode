package Mission_2025.January.Math;

public class Set_Matrix_Zeroes {
    public void setZeroes(int[][] matrix) {
        boolean first_row = false;
        boolean first_col = false;
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                if (i==0 && matrix[i][j]==0){
                    first_row=true;
                }
                if (j==0 && matrix[i][j]==0){
                    first_col=true;
                }

                if (i!=0 && j!=0){
                    if (matrix[i][j]==0){
                        matrix[0][j]=0;
                        matrix[i][0]=0;
                    }
                }
            }
        }

        for (int i=0;i<matrix.length;i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i>0 && j>0 && (matrix[i][0]==0 || matrix[0][j]==0)){
                    matrix[i][j]=0;
                }
            }
        }

        if (first_row){
            for (int i=0;i<matrix[0].length;i++){
                matrix[0][i]=0;
            }
        }

        if (first_col){
            for (int i=0;i<matrix.length;i++){
                matrix[i][0]=0;
            }
        }
    }

}
