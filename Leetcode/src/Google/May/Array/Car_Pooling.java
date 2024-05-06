package Google.May.Array;

import java.util.*;

public class Car_Pooling {

    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));

        int avail = capacity;
        for (int i=0;i<trips.length;i++){
            while (!pq.isEmpty() && pq.peek()[0]<=trips[i][1]){
                int[] temp = pq.poll();
                avail+= temp[1];

            }



            pq.add(new int[]{trips[i][2],trips[i][0]});
            avail-= trips[i][0];
            if (avail<0){
                return false;
            }
        }

        return true;


    }


}
