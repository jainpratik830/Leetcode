package Mission_2025.January.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Maximum_Length_of_Pair_Chain {
    public int binarySearch(List<Integer> lis, int[] limit){
        int low = 0;
        int high = lis.size()-1;
        int ans =0;
        while (low<=high){

            int mid = (low+high)/2;
            if (lis.get(mid)<limit[0]){
                ans = mid+1;
                low=mid+1;
            }else {
                high=mid-1;
            }

        }

        return ans;


    }


    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]){
                    return o2[1]-o1[1];
                }
                return o1[0]-o2[0];
            }
        });
        List<Integer> resp = new ArrayList<>();
        int[] dp = new int[pairs.length];
        Arrays.fill(dp,1);
        int maxSize =1;
        int maxIndex =0;
        for (int i=1;i<pairs.length;i++){
            for (int j=0;j<i;j++){

                if (pairs[i][0]>pairs[j][1]){
                    dp[i]= Math.max(dp[i],dp[j]+1);
                }
                if (dp[i]>maxSize){
                    maxSize=dp[i];
                }
            }
        }


        return maxSize;
    }
}
