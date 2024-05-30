package Google.May.Others;

import java.util.Arrays;

public class Special_Array_With_X_Elements_Greater {


    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int low = 0;
        int high = nums.length-1;
        // System.out.println(Arrays.toString(nums));
        while (low<=high){
            // System.out.println("low="+low+" high="+high);
            int mid = low + (high-low)/2;

            int count =  nums.length-mid;
            if ((count<=nums[mid]) && (mid==0 || count>nums[mid-1])){
                return count;
            }

            if (count>nums[mid]){
                low=mid+1;
                // high=mid-1;
            }else {
                high=mid-1;
                // low=mid+1;
            }

        }

        return -1;
    }

}
