package Google.July;

import java.util.ArrayDeque;
import java.util.Deque;

public class Constrained_Subsequence_Sum {

    public int constrainedSubsetSum(int[] nums, int k) {
        int[] dp = new int[nums.length];
        Deque<int[]> deque= new ArrayDeque<>();


        for (int i=0;i<nums.length;i++){

            while (!deque.isEmpty() && i-deque.peek()[1]>k){
                deque.poll();
            }

            dp[i] = (!deque.isEmpty()? deque.peek()[0]: 0)+nums[i];

            while (!deque.isEmpty() && deque.peekLast()[0]<dp[i]){
                deque.pollLast();
            }

            if (dp[i] > 0) {
                deque.offer(new int[]{dp[i],i});
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int i:dp){
            ans = Math.max(ans,i);
        }

        return ans;

    }


}
