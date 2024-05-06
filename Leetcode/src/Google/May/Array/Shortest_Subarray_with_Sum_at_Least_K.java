package Google.May.Array;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class Shortest_Subarray_with_Sum_at_Least_K {


    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int ans = n+1;
        Deque<Integer> deque = new ArrayDeque<>();
        long[] prefixSum = new long[n+1];
        for (int i=0;i<n;i++){
            prefixSum[i+1]=prefixSum[i]+nums[i];
        }

        for (int i=0;i<n+1;i++){


//            This is used to find the min length using the indexed from queue from left to right and removing that if the condition holds
            while (!deque.isEmpty() && prefixSum[i]-prefixSum[deque.peek()]>=k){
                ans = Math.min(ans,i-deque.poll());
            }

//            This is used to remove all the indexed where the deque is not strictly increasing
            while (!deque.isEmpty() && prefixSum[i]<=prefixSum[deque.peekLast()]){
                deque.pollLast();
            }

            deque.add(i);


        }

        return ans == n+1 ? -1 : ans;

    }

}
