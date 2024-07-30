package Google.July;

import java.util.ArrayDeque;
import java.util.Deque;

public class Longest_Subarray_With_Diff_Less_Than_Limit {

    public int longestSubarray(int[] nums, int limit) {
        int left=0,right=0;
        Deque<Integer> maxDeque= new ArrayDeque<>();
        Deque<Integer> minDeque= new ArrayDeque<>();
        int ans =0;
        for (right=0;right<nums.length;right++){

            while (!maxDeque.isEmpty() && maxDeque.peekLast()< nums[right]){
                maxDeque.pollLast();
            }
            maxDeque.offerLast(nums[right]);

            while (!minDeque.isEmpty() && minDeque.peekLast()> nums[right]){
                minDeque.pollLast();
            }
            minDeque.offerLast(nums[right]);


            while (Math.abs(maxDeque.peekFirst()-minDeque.peekFirst())>limit){

                if (maxDeque.peekFirst()==nums[left]){
                    maxDeque.pollFirst();
                }

                if (minDeque.peekFirst()==nums[left]){
                    minDeque.pollFirst();
                }

                left++;
            }

            ans = Math.max(ans,right-left+1);
        }

        return ans;


    }

}
