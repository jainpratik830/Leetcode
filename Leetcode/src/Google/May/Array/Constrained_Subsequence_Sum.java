package Google.May.Array;

import java.util.Map;
import java.util.PriorityQueue;

public class Constrained_Subsequence_Sum {

    public int constrainedSubsetSum(int[] nums, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(b[0]-a[0]));
        pq.add(new int[]{nums[0],0});

        int ans =nums[0];
        for (int i=1;i<nums.length;i++){
            while (!pq.isEmpty() && i-pq.peek()[1]>k){
                pq.poll();
            }
            if (!pq.isEmpty()){
                int curr = Math.max(0,pq.peek()[0])+nums[i];
                pq.add(new int[]{curr,i});
                ans=Math.max(ans,curr);
            }
            else {
                pq.add(new int[]{nums[i],i});
                ans=Math.max(ans,nums[i]);
            }
        }

        return ans;
    }


}
