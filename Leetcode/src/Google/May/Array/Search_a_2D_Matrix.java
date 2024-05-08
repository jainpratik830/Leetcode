package Google.May.Array;

public class Search_a_2D_Matrix {



    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int high= matrix.length-1;

        while (low<=high){
            int mid = low + (high-low)/2;

            if (matrix[mid][0]==target){
                return true;
            }

            if (matrix[mid][0]>target){
                high = mid-1;
            }else {
                low=mid+1;
            }
        }

        // System.out.println(low);
        // System.out.println(high);
        if(high<0){
            return false;
        }
        int row = high;
        low = 0;
        high= matrix[row].length-1;

        while (low<=high){
            int mid = low + (high-low)/2;

            if (matrix[row][mid]==target){
                return true;
            }

            if (matrix[row][mid]>target){
                high = mid-1;
            }else {
                low=mid+1;
            }
        }
        return false;
    }

}
