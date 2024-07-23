package Google.July;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Sort_Array_by_Increasing_Frequency {

    public int[] frequencySort(int[] nums) {
        int[] ans = new int[nums.length];

        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1]==o2[1]){
                    return o2[0]-o1[0];
                }
                return o1[1]-o2[1];
            }
        });

        for (int i:map.keySet()){
            pq.add(new int[]{i,map.get(i)});
        }

        int i=0;
        while (i<nums.length){
            int[] curr = pq.poll();
            for (int j=0;j<curr[1];j++){
                ans[i++]=curr[0];
            }
        }
        return ans;
    }

}
