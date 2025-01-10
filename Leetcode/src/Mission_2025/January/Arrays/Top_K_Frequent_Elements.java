package Mission_2025.January.Arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Top_K_Frequent_Elements {

    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];

        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
        for (int i:map.keySet()){
            pq.add(new int[]{i,map.get(i)});
            if (pq.size()>k){
                pq.poll();

            }
        }

        for (int i=0;i<k;i++){
            ans[i]=pq.poll()[0];
        }

        return ans;
    }

    public int[] topKFrequent2(int[] nums, int k) {
        int[] ans = new int[k];

        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        int[][] top = new int[map.keySet().size()][2];
        int j=0;
        for (int i:map.keySet()){
            top[j][0]= i;
            top[j++][1]=map.get(i);
        }

        Arrays.sort(top, Comparator.comparingInt(a->-a[1]));

        for (int i=0;i<k;i++){
            ans[i]=top[i][0];
        }

        return ans;
    }


}
