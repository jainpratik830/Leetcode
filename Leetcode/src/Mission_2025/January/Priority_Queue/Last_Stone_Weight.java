package Mission_2025.January.Priority_Queue;

import java.util.Collections;
import java.util.PriorityQueue;

public class Last_Stone_Weight {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i:stones){
            pq.add(i);
        }

        while (pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();
            if (x==y){
                continue;
            }else {
                pq.add(x-y);
            }
        }

        return pq.isEmpty() ? 0 : pq.poll();

    }

}
