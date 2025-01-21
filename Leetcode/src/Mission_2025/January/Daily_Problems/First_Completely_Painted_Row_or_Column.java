package Mission_2025.January.Daily_Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class First_Completely_Painted_Row_or_Column {

    public static void main(String[] args){
        System.out.println(Thread.currentThread().getId());
    }

    public int firstCompleteIndex(int[] arr, int[][] mat) {


        HashMap<Integer, int[]> map = new HashMap<>();
        int n= mat.length;
        int m = mat[0].length;

        boolean[][] painted= new boolean[n][m];
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                map.put(mat[i][j],new int[]{i,j});
            }
        }

        int[] rowCount = new int[n];
        int[] colCount = new int[m];
        int index= 0;
        for(int i:arr){

            // System.out.println("For key :"+i);

            int[] j=map.get(i);
            // System.out.println("Painting index :"+j[0]+","+j[1]);
            rowCount[j[0]]++;
            colCount[j[1]]++;
            if (rowCount[j[0]]==m || colCount[j[1]]==n){
                return index;
            }
            // painted[j[0]][j[1]]=true;


            // System.out.println("Row key :"+ Arrays.toString(rowCount));
            // System.out.println("Col key :"+ Arrays.toString(colCount));

            index++;
        }
        return arr.length;

    }

}
