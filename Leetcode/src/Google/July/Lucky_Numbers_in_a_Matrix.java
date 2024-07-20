package Google.July;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Lucky_Numbers_in_a_Matrix {

    public List<Integer> luckyNumbers (int[][] matrix) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int m = matrix.length;
        int n= matrix[0].length;
        for (int i=0;i<n;i++){
            int max = Integer.MIN_VALUE;
            for (int j=0;j<m;j++){
                max= Math.max(max,matrix[j][i]);
            }
            map.put(i,max);
        }

        for (int i=0;i<m;i++){
            int min = Integer.MAX_VALUE;
            int col =  0;
            for (int j=0;j<n;j++){
                if (min>matrix[i][j]){
                    min = matrix[i][j];
                    col=j;
                }
            }
            if (map.get(col)==min){
                ans.add(min);
            }
        }

        return ans;
    }


}
