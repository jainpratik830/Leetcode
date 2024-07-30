package Google.July;

import java.util.*;

public class Sliding_Window_Maximum {

    public int[] maxSlidingWindow2(int[] nums, int k) {
        int[] ans = new int[nums.length-k+1];
        int index=0;
        PriorityQueue<int[]> pq=  new PriorityQueue<>(Comparator.comparingInt(a->-a[0]));

        for (int i=0;i<k;i++){
            pq.add(new int[]{nums[i],i});
        }
        ans[index++]=(pq.peek()[0]);
        for (int i=k;i<nums.length;i++){
            while (!pq.isEmpty() && i-pq.peek()[1]>=k){
                pq.poll();
            }
            pq.add(new int[]{nums[i],i});
            ans[index++]=(pq.peek()[0]);

        }

        return ans;
    }

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
