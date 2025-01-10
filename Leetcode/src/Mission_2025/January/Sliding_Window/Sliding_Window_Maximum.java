package Mission_2025.January.Sliding_Window;

import java.util.ArrayDeque;
import java.util.Deque;

public class Sliding_Window_Maximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length-k+1];
        Deque<Integer> deque = new ArrayDeque<>();

        int right= 0;
        while (right<nums.length){
            int curr = nums[right];
            while (!deque.isEmpty() && nums[deque.peekLast()]<curr){
                deque.pollLast();
            }

            while (!deque.isEmpty() && deque.peekFirst()<right-k+1){
                deque.pollFirst();
            }

            deque.addLast(right);
//            right++;

            if (right>=k-1){
                ans[right-k+1]=nums[deque.peekFirst()];
            }
            right++;
        }

        return ans;


    }

}
