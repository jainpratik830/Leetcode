package Google.July;

public class Maximum_Product_Subarray {

    public int maxProduct(int[] nums) {
        int max_so_far = nums[0];
        int min_so_far = nums[0];
        int result = max_so_far;

        for (int i=1;i<nums.length;i++){

            int temp = max_so_far;
            int curr =nums[i];
            max_so_far = Math.max(curr,Math.max(curr*min_so_far,curr*temp));
            min_so_far = Math.min(curr,Math.min(curr*min_so_far,curr*temp));


            result =Math.max(result,max_so_far);

        }

        return result;
    }

}
