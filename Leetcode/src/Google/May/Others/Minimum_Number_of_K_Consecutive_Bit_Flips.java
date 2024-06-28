package Google.May.Others;

import java.util.LinkedList;
import java.util.Queue;

public class Minimum_Number_of_K_Consecutive_Bit_Flips {

    public int minKBitFlips(int[] nums, int k) {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int i=0;i<=nums.length-k;i++){
            if (!queue.isEmpty() && queue.peek()<=i-k){
                queue.poll();
            }
            if ((nums[i]+queue.size())%2==0)
            {
                if (i+k>nums.length){
                    return -1;
                }
                count++;
                queue.add(i);
            }
            // System.out.println(Arrays.toString(nums));
        }


        return count;
    }


}
