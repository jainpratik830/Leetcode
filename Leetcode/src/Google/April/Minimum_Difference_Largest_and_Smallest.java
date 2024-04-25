package Google.April;

import java.util.Arrays;

public class Minimum_Difference_Largest_and_Smallest {

    public int minDifference(int[] nums) {
        int ans = Integer.MAX_VALUE;
        if (nums.length<=4){
            return 0;
        }
        int n = nums.length;


        Arrays.sort(nums);
        ans = nums[n-1]-nums[3];
        ans = Math.min(ans,nums[n-2]-nums[2]);
        ans = Math.min(ans,nums[n-3]-nums[1]);
        ans = Math.min(ans,nums[n-4]-nums[0]);
        return ans;
    }




}
