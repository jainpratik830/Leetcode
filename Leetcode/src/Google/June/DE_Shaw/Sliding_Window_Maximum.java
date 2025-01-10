package Google.June.DE_Shaw;

import java.util.ArrayDeque;
import java.util.Deque;

public class Sliding_Window_Maximum {


    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] ans = new int[nums.length-k+1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i=0;i<k;i++){
            while (!deque.isEmpty() && nums[deque.peekLast()]<nums[i]){
                deque.pollLast();
            }
            deque.addLast(i);
        }
        // System.out.println(deque);
        ans[0]=nums[deque.peekFirst()];
        for (int i=k;i<nums.length;i++){
            while (!deque.isEmpty() && i-deque.peekFirst()>=k){
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()]<nums[i]){
                deque.pollLast();
            }
            deque.addLast(i);
            // System.out.println(deque);
            ans[i-k+1]=nums[deque.peekFirst()];
        }
        return ans;

    }

}

