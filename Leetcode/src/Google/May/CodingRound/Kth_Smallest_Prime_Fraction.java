package Google.May.CodingRound;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Kth_Smallest_Prime_Fraction {


    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<double[]> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> a[0]));

        for (int i=0;i<arr.length-1;i++){
            double fract = (1.0*arr[i]/arr[arr.length-1]);
            pq.offer(new double[]{fract,i,arr.length-1});

        }

        while (--k>0){

            double[] curr = pq.poll();
            int num = (int) curr[1];
            int den = (int) curr[2]-1;
            if (den>num){
                pq.offer(new double[]{
                        (1.0*arr[num]/arr[den]),
                num,
                den
                });
            }


        }

        double[] result = pq.poll();
        return new int[]{arr[(int) result[1]], arr[(int) result[2]]};

    }

}
