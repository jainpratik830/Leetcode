package Google.August;

import java.util.PriorityQueue;

public class Kth_Largest_Element_in_a_Stream {

    class KthLargest {

        int k;
        PriorityQueue<Integer> priorityQueue= new PriorityQueue<>();

        public KthLargest(int k, int[] nums) {
            priorityQueue = new PriorityQueue<>();
            this.k=k;
            for (int i=0;i<nums.length;i++){
                this.add(nums[i]);
            }

        }

        public int add(int val) {
            priorityQueue.add(val);
            if (priorityQueue.size()>k){
                priorityQueue.poll();
            }


            return priorityQueue.peek();
        }
    }

}
