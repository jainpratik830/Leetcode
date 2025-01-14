package Mission_2025.January.Priority_Queue;

import java.util.Collections;
import java.util.PriorityQueue;

public class Kth_Largest_Element_in_a_Stream {


    class KthLargest {

        PriorityQueue<Integer> pq;
        int k;

        public KthLargest(int k, int[] nums) {
            pq= new PriorityQueue<>();
            this.k= k;
            for (int i=0;i<nums.length;i++){
                pq.add(nums[i]);
                if (pq.size()>k){
                    pq.poll();
                }
            }

        }

        public int add(int val) {

            if (pq.size()<k || pq.peek()<val ){
                pq.add(val);
                if (pq.size()>k){
                    pq.poll();
                }
            }

            return pq.peek();
        }
    }

}
