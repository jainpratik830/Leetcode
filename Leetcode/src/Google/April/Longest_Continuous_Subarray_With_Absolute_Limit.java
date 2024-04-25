package Google.April;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Longest_Continuous_Subarray_With_Absolute_Limit {

    public int longestSubarray(int[] nums, int limit) {
        int ans = 0;

        int left = 0;
        int right =0;
        PriorityQueue<int[]> min_queue=  new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> max_queue=  new PriorityQueue<>((a,b)->b[0]-a[0]);
        while (left<=right && right<nums.length){
            min_queue.add(new int[]{nums[right],right});
            max_queue.add(new int[]{nums[right],right});
            if (Math.abs(min_queue.peek()[0]-max_queue.peek()[0])<=limit){
                // System.out.println("left="+left+" right="+right);
                ans = Math.max(ans,right-left+1);
                right++;
            }else {
                int i=Math.min(min_queue.peek()[1],max_queue.peek()[1]);
                while (min_queue.peek()[1]<=i){
                    min_queue.poll();
                }
                while (max_queue.peek()[1]<=i){
                    max_queue.poll();
                }
                left=i+1;
            }
        }
        return ans;
    }

}
