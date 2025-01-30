package Zeta;

public class Find_First_and_Last_Position_of_Element_in_Sorted_Array {

    public int lower_bound(int[] nums,int target){
        int low =0;
        int high = nums.length-1;
        while (low<high){
            int mid = (low+high)/2;
            if (nums[mid]>=target){
                high=mid;
            }else {
                low= mid+1;
            }

        }

        return low;
    }

    public int upper_bound(int[] nums,int target){
        int low =0;
        int high = nums.length-1;
        while (low<high){
            int mid = (low+high)/2;
            if (nums[mid]>target){
                high=mid-1;
            }else {
                low= mid;
            }

        }

        return low;
    }

    public int[] searchRange(int[] nums, int target) {
        int left= lower_bound(nums,target);
        int right =upper_bound(nums,target);
        if (nums[left]!=target){
            return new int[]{-1,-1};
        }
        return new int[]{left,right};
    }

}
