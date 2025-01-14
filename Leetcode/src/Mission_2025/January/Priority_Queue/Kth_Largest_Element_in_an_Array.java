package Mission_2025.January.Priority_Queue;

import java.util.PriorityQueue;

public class Kth_Largest_Element_in_an_Array {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        for (int i=0;i<nums.length;i++){
            if (pq.size()<k || pq.peek()<nums[i])
                pq.add(nums[i]);
            if (pq.size()>k){
                pq.poll();
            }
        }

        return pq.peek();
    }

}
