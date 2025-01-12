package Mission_2025.January.Binary_Search;

public class Search_in_Rotated_Sorted_Array {

    public int search(int[] nums, int target) {
        int left= 0;
        int right = nums.length-1;

        while (left<=right){

            int mid = (left+right)/2;

            if (nums[mid]==target){
                return mid;
            }

            if (nums[mid]>nums[left] && target>=nums[left] && target<=nums[mid]){

                right= mid-1;
            }else if (nums[mid]<nums[left] && ((target>nums[right] && target>nums[mid]) || ( target<nums[right] && target<nums[mid]) )){
                right= mid-1;
            }else {
                left= mid+1;
            }
        }
        return -1;
    }

}
