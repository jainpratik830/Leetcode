package Google.April;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Constrained_Subsequence_Sum {

//    T(n) = O(nlogn)
//    S(n) = O(n)

    public int constrainedSubsetSum(int[] nums, int k) {



        int[] dp = new int[nums.length];

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        // Arrays.fill(dp,Integer.MIN_VALUE);
        for (int i=0;i<nums.length;i++){
            dp[i]= nums[i];
            if (pq.isEmpty()){
                continue;
            }
            while (i-pq.peek()[1]>k){
                pq.poll();
            }
            int[] curr = pq.peek();
            dp[i]= Math.max(curr[0]+nums[i],dp[i]);
            pq.add(new int[]{nums[i],i});

        }

        int ans = Integer.MIN_VALUE;
        for(int i:dp){
            ans=Math.max(ans,i);
        }
        System.out.println(Arrays.toString(dp));
        return ans;
    }


}
