package Google.July;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Maximum_Subsequence_Score {

    public long maxScore(int[] nums1, int[] nums2, int k) {
        long ans =0;
        int[][] arr = new int[nums1.length][2];

        for (int i=0;i<nums1.length;i++){
            arr[i] = new int[]{nums1[i],nums2[i]};
        }

        Arrays.sort(arr, Comparator.comparingInt(a->-a[1]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long total = 0;
        for (int i=0;i<nums1.length;i++){
            pq.add(arr[i][0]);
            total += arr[i][0];
            if (pq.size()>k){
                total-= pq.poll();
            }

            if (pq.size()==k){
                ans = Math.max(ans,total*arr[i][1]);
            }
        }

        return ans;
    }

}
