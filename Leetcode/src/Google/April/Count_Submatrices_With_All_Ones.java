package Google.April;

public class Count_Submatrices_With_All_Ones {

    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int ans =0;

        for (int i=1;i<m;i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j]==1){
                    mat[i][j] += mat[i-1][j];
                }

            }
        }

        int rt = 0;

        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){

                if (mat[i][j]>0){
                    rt = mat[i][j];
                    for (int k=j+1;k<n;k++){
                        if (mat[i][k]>0) {
                            rt = Math.min(rt, mat[i][k]);
                            mat[i][j] += rt;
                        }
                        else
                            break;
                    }

                }
                ans += mat[i][j];
            }
        }

        return ans;
    }

}
