package Mission_2025.January.Arrays;

import java.util.Arrays;

public class Product_of_Array_Except_Self {

    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        Arrays.fill(prefix,1);
        Arrays.fill(suffix,1);
        for (int i=1;i<nums.length-1;i++){
            prefix[i]=prefix[i-1]*nums[i-1];
            suffix[nums.length-1-i]=suffix[nums.length-i]*nums[nums.length-i];
        }
        prefix[nums.length-1]=prefix[nums.length-2]*nums[nums.length-2];
        suffix[0]=suffix[1]*nums[1];
        for (int i=0;i<nums.length;i++){
            ans[i]=prefix[i]*suffix[i];
        }

        return ans;
    }
}
