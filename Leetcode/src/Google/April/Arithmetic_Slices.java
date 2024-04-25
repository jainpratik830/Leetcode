package Google.April;

public class Arithmetic_Slices {

    public int numberOfArithmeticSlices(int[] nums) {
        int ans =0;
        int count =0;

        int i=2;
        while (i<nums.length){
            if (nums[i-2]-nums[i-1]==nums[i-1]-nums[i]){
                count++;
                ans +=count;
            }else {
                count=0;
            }
            i++;

        }
        return ans;


    }

}
