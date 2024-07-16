package Google.July;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Sliding_Window_Maximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();

        Deque<Integer> deque =new ArrayDeque<>();
        for (int i=0;i<k;i++){
            while (!deque.isEmpty() && nums[deque.peekLast()]<=nums[i]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        ans.add(nums[deque.peekFirst()]);

        for (int i=k;i< nums.length;i++){
            if (deque.peekFirst()<=i-k){
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()]<=nums[i]){
                deque.pollLast();
            }
            deque.offerLast(i);
            ans.add(nums[deque.peekFirst()]);
        }

        return ans.stream().mapToInt(a->a).toArray();
    }

}
