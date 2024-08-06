package Google.August;

public class Maximum_Product_Subarray {

    public int maxProduct(int[] nums) {
        long left = 1,right =1;
        long ans =nums[0];

        for (int i=0;i<nums.length;i++){
            if (left==0){
                left=1;
            }
            if(right==0){
                right=1;
            }

            left = left*nums[i];
            right= right*nums[nums.length-1-i];
            if(left > Integer.MAX_VALUE || left< Integer.MIN_VALUE)
                left =1;

            if(right > Integer.MAX_VALUE || right< Integer.MIN_VALUE)
                right =1;
            ans = Math.max(ans,Math.max(left,right));
        }

        return (int) ans;
    }

}
