package Mission_2025.January.Binary_Search;

public class Find_Minimum_in_Rotated_Sorted_Array {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;

        while (left<right){

            int mid = (left+right)/2;

            if (nums[mid]< nums[right]){
                right=mid;
            }else {
                left=mid+1;
            }

        }


        return right;
    }

}
