package Google.April;

import java.util.Collections;
import java.util.PriorityQueue;

public class Furthest_Building_You_Can_Reach {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int ladder = ladders;
        int brick = bricks;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i=0;i<heights.length-1;i++){

            if (heights[i + 1]>heights[i]){
                priorityQueue.add(heights[i + 1]-heights[i]);
                brick=brick-(heights[i + 1]-heights[i]);
                if (brick < 0 && ladder == 0) {
                    return i;
                }
                if (brick < 0) {
                    brick += priorityQueue.remove();
                    ladder--;
                }

            }



        }
        return heights.length-1;
    }

}
