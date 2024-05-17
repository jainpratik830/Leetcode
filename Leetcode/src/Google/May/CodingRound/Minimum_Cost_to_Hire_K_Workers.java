package Google.May.CodingRound;

import java.util.*;

public class Minimum_Cost_to_Hire_K_Workers {

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        double ans =Double.MAX_VALUE;

        List<double[]> list = new ArrayList<>();
        for (int i=0;i<quality.length;i++){
            list.add(new double[]{(1.0*wage[i])/quality[i],quality[i]});
        }
        Collections.sort(list, Comparator.comparingDouble(a->a[0]));
        PriorityQueue<double[]> pq = new PriorityQueue<>(Comparator.comparingDouble((a->-a[1]) ));
        double total= 0;
        for (double[] i:list){
            // System.out.println(Arrays.toString(i));
            pq.add(i);
            total+=i[1];
            if (pq.size()>k){
                total -= pq.poll()[1];
                // System.out.println(total);
            }

            if (pq.size()==k){
                ans = Math.min(ans,total*i[0]);
            }
        }

        return ans;
    }

}
