package Google.June.DE_Shaw;

import java.util.Arrays;

public class Minimum_Moves_to_Equal_Array_Elements_II {

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int count = 0;
        if(nums.length%2==0){
            int higher = nums.length/2;
            int lower= higher -1;
            int count1 = 0,count2=0;
            for(int i:nums){
                count1 += Math.abs(nums[lower]-i);
                count2 += Math.abs(nums[higher]-i);
            }
            count = Math.min(count1,count2);
        }else{
            int mid = nums.length/2;
            for(int i:nums){
                count += Math.abs(nums[mid]-i);
            }
        }



        return count;
    }


}
