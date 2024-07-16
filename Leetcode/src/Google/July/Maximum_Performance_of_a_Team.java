package Google.July;

import java.util.*;

public class Maximum_Performance_of_a_Team {

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int modulo = (int) 10e7;
        List<int[]> list = new ArrayList<>();
        for (int i=0;i<n;i++){
            list.add(new int[]{efficiency[i],speed[i]});
        }

        Collections.sort(list, Comparator.comparingInt(a->-a[0]));
        long sum=0;
        long res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int[] i:list){
            int currSpeed = i[1];
            int currEff = i[0];

            if (pq.size()>k-1){
                sum -= pq.poll();

            }

            pq.add(currSpeed);
            sum+=currSpeed;
            res = Math.max(sum*currEff,res);
        }

        return (int) res%modulo;
    }

}
