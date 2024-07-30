package Google.July;

import java.util.Arrays;

public class Trapping_Rain_Water_II {

    public void print(int[][] arr){
        for (int[] i:arr){
            System.out.println(Arrays.toString(i));
        }
    }

    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        int[][] left = new int[m][n];
        int[][] right = new int[m][n];
        int[][] up = new int[m][n];
        int[][] down = new int[m][n];

        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (j==0){
                    left[i][j]=heightMap[i][j];
                }else {
                    left[i][j]=Math.max(heightMap[i][j],left[i][j-1]);
                }

                if (i==0){
                    up[i][j]=heightMap[i][j];
                }else {
                    up[i][j]=Math.max(heightMap[i][j],up[i-1][j]);
                }

            }
        }

        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if (j==n-1){
                    right[i][j]=heightMap[i][j];
                }else {
                    right[i][j]=Math.max(heightMap[i][j],right[i][j+1]);
                }

                if (i==m-1){
                    down[i][j]=heightMap[i][j];
                }else {
                    down[i][j]=Math.max(heightMap[i][j],down[i+1][j]);
                }
            }

        }
        // print(left);
        // print(right);
        // print(up);
        // print(down);
        int ans =0;

        for (int i=0;i<m;i++) {
            for (int j = 0; j < n; j++) {
                int val =  Math.min(Math.min(up[i][j],down[i][j]),Math.min(left[i][j],right[i][j]))-heightMap[i][j];
                ans +=val;
                // if(val<0)
                //     System.out.println(i+"=i j="+j+" val="+val);
            }
        }

        return ans;
    }

}
