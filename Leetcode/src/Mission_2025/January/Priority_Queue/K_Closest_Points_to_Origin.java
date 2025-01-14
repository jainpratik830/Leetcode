package Mission_2025.January.Priority_Queue;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

public class K_Closest_Points_to_Origin {

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq  = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int x1= o1[0];
                int x2=o2[0];
                int y1 = o1[1];
                int y2=o2[1];
                return Double.compare(-1*Math.sqrt(Math.pow(x1,2)+Math.pow(y1,2)),-1*Math.sqrt(Math.pow(x2,2)+Math.pow(y2,2)));

            }
        });

        for (int[] point:points){
            pq.add(point);
            if (pq.size()>k){
                pq.poll();
            }
        }

        int[][] ans = new int[k][2];
        pq.toArray(ans);

        return ans;
    }

}
