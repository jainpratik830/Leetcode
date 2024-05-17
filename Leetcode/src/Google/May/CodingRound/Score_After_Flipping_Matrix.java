package Google.May.CodingRound;

public class Score_After_Flipping_Matrix {

    public int matrixScore(int[][] grid) {


        int m = grid.length;
        int n = grid[0].length;
        int score =0;
        for (int i=0;i<m;i++){

            if (grid[i][0]==0){
                for (int j=0;j<n;j++){
                    grid[i][j]=1-grid[i][j];

                }
            }

        }

        for (int i=1;i<n;i++){
            int ones = 0;
            int zeros =0;
            for (int j=0;j<m;j++){
                if (grid[j][i]==1){
                    ones++;
                }else {
                    zeros++;
                }
            }
            if (zeros>ones){
                for (int j=0;j<m;j++){
                    grid[j][i]=1-grid[j][i];
                }
            }

        }

        for (int i=0;i<m;i++){
            int pow=1;
            for (int j=n-1;j>=0;j--){
                score+= grid[i][j]*pow;
                pow*=2;
            }
        }

        return score;

    }

}
