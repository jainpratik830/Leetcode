package Mission_2025.January.Binary_Search;

public class Search_a_2D_Matrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        int left = 0;
        int right = matrix.length-1;

        while (left<=right){
            int mid = (left+right)/2;
            if (matrix[mid][0]==target){
                return true;
            }
            if (matrix[mid][0]<target){
                left = mid+1;
            }else {
                right= mid-1;
            }
        }
        if(right<0){
            return false;
        }
        int row = right;
        left=0;
        right= matrix[row].length-1;


        while (left<=right){
            int mid = left+ (right-left)/2;
            if (matrix[row][mid]==target) {
                return true;
            }
            if (matrix[row][mid]>target){
                right= mid-1;
            }else {
                left= mid+1;
            }
        }

        return false;
    }


}
