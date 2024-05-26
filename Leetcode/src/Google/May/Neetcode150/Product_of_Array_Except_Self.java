package Google.May.Neetcode150;

public class Product_of_Array_Except_Self {

    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0]=1;
        ans[1]=nums[0];
        for (int i=2;i<nums.length;i++){
            ans[i]=nums[i-1]*ans[i-1];

        }

        for (int i=nums.length-2;i>=0;i--){
            ans[i] *= nums[i+1];
            nums[i] *=nums[i+1];

        }

        return ans;

    }

}
