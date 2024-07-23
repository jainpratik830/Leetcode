package Google.July;

public class Minimum_Replacements_to_Sort_the_Array {

    public long minimumReplacement(int[] nums) {
        long ans = 0;

        for (int i=nums.length-2;i>=0;i--){

            if (nums[i]<=nums[i+1]){
                continue;
            }

            long numElements =(long) (nums[i]+nums[i+1]-1)/nums[i+1];
            ans += numElements-1;
            nums[i]=nums[i]/(int) numElements;


        }
        return ans;
    }

}
