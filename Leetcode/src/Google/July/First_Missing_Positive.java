package Google.July;

public class First_Missing_Positive {

    public int firstMissingPositive(int[] nums) {
       int i=0;
       while (i<nums.length){
           int index = nums[i]-1;
           if (nums[i]>0 && nums[i]<=nums.length && nums[i]!=nums[index]){
               int temp = nums[i];
               nums[i]=nums[index];
               nums[index]=temp;
            }else {
                i++;

            }

        }


        for (i=0;i<nums.length;i++){
            if (nums[i]!=i+1){
                return i+1;
            }
        }

        return nums.length+1;


    }

}
