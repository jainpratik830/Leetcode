package Google.July;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Minimum_Cost_to_Hire_K_Workers {

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        double ans =Double.MAX_VALUE;
        PriorityQueue<double[]> pq = new PriorityQueue<>(Comparator.comparingDouble(a->-a[1]));
        double[][] arr = new double[quality.length][2];
        for (int i=0;i<quality.length;i++){
            arr[i]= new double[]{(1.0*wage[i])/quality[i],quality[i]};
        }
        Arrays.sort(arr,Comparator.comparingDouble(a->a[0]));
        double curr=0;
        for (int i=0;i<quality.length;i++){
            pq.offer(arr[i]);
            curr += arr[i][1];

            if (pq.size()>k){
                curr-= pq.poll()[1];
            }

            if (pq.size()==k){
                ans = Math.min(ans,curr*arr[i][0]);
            }
        }

        return ans;


    }

}
