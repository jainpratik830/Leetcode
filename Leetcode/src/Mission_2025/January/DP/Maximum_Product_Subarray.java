package Mission_2025.January.DP;

import Google.May.Neetcode150.MinStack;

public class Maximum_Product_Subarray {

    public int maxProduct(int[] nums) {
        int n= nums.length;
        int min = nums[0],max= nums[0];
        int res= nums[0];
        for (int i=1;i<nums.length;i++){
            int tmp = max*nums[i];
            max =Math.max(nums[i],Math.max(nums[i]*max,nums[i]*min));
            min = Math.min(nums[i],Math.min(tmp,nums[i]*min));
            res = Math.max(res, Math.max(max, min));
        }
        return res;

    }

    public int maxProduct2(int[] nums) {
        int n= nums.length;
        int prefix = 0,suffix= 0;
        int res= nums[0];
        for (int i=0;i<nums.length;i++){
            prefix = nums[i] * (prefix == 0 ? 1 : prefix);
            suffix = nums[n - 1 - i] * (suffix == 0 ? 1 : suffix);
            res = Math.max(res, Math.max(prefix, suffix));
        }
        return res;

    }

}
