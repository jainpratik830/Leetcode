package Google.May.Others;

import java.util.Map;

public class Maximum_Subarray {

    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int curr = nums[0];

        for (int i=1;i<nums.length;i++){
            curr = Math.max(nums[i],nums[i]+curr);

            ans = Math.max(ans,curr);
        }

        return ans;
    }

}
