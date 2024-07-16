package Google.July;

import java.util.Collections;
import java.util.PriorityQueue;

public class Furthest_Building_You_Can_Reach {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int ans =0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i=0;i<heights.length-1;i++){
            if (heights[i+1]>heights[i]){
                pq.add(heights[i+1]-heights[i]);
                bricks-= heights[i+1]-heights[i];
                if (bricks<0 && ladders==0){
                    return i;
                }
                if (bricks<0){
                    bricks+= pq.poll();
                    ladders--;
                }
            }
        }


        return heights.length-1;
    }

}
