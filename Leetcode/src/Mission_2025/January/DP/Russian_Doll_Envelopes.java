package Mission_2025.January.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Russian_Doll_Envelopes {

    public int binarySearch(List<Integer> lis,int[] limit){
        int low = 0;
        int high = lis.size()-1;
        int ans =0;
        while (low<=high){

            int mid = (low+high)/2;
            if (lis.get(mid)<limit[1]){
                ans = mid+1;
                low=mid+1;
            }else {
                high=mid-1;
            }

        }

        return ans;


    }

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]){
                    return o2[1]-o1[1];
                }
                return o1[0]-o2[0];
            }
        });

        List<Integer> lis = new ArrayList<>();
        lis.add(envelopes[0][1]);
        // for (int[] i:envelopes){
        //     System.out.print(Arrays.toString(i)+",");
        // }
        // System.out.println();
        for (int i=1;i<envelopes.length;i++){
            int mid = binarySearch(lis,envelopes[i]);
            if (mid< lis.size()) {
                lis.set(mid,envelopes[i][1]);
            }else{
                lis.add(envelopes[i][1]);
            }
            // System.out.println(lis);
        }
        return lis.size();
    }

}
