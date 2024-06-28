package Google.May.Others;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Maximum_Total_Importance_of_Roads {

    public long maximumImportance(int n, int[][] roads) {
        int[] inDegree = new int[n];
        for (int[] edge:roads){
            inDegree[edge[0]]++;
            inDegree[edge[1]]++;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->-1*a[0]));
        for (int i=0;i<n;i++){
            pq.add(new int[]{inDegree[i],i});
        }

        int curr = n;
        int[] assigned = new int[n];
        for (int i=0;i<n;i++){
            int[] temp =pq.poll();
            System.out.println(Arrays.toString(temp));
            assigned[temp[1]]=curr;
            curr--;
        }
        System.out.println(Arrays.toString(assigned));
        long ans =0;
        for (int[] edge:roads){
            ans+= assigned[edge[0]]+assigned[edge[1]];
        }

        return ans;
    }

}
