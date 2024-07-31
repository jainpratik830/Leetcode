package Google.July;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class IPO {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] projects = new int[n][2];

        for(int i = 0; i < n; ++i) {
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Arrays.sort(projects, Comparator.comparingInt(a->a[0]));
        int index= 0;
        while (k-->0){
            while (index<profits.length && projects[index][0]<=w){
                pq.add(projects[index++][1]);
            }

            if (pq.isEmpty()){
                break;
            }

            w += pq.poll();
        }

        return w;
    }

}
