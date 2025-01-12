package Mission_2025.January.Binary_Search;

import java.util.Arrays;
import java.util.Map;

public class Koko_Eating_Bananas {
    public int minEatingSpeed(int[] piles, int h) {
//        Arrays.sort(piles);

        int total = (Arrays.stream(piles).max().getAsInt());
        int left = 0;
        int right = total;

        while (left<right){

            int mid = left + (right-left)/2;

            int count =0;
            for (int i:piles){
                count += Math.ceil((i*1.0)/mid);
            }

            if (count>h){
                left=mid+1;
            }else {
                right=mid;
            }

        }

        return right;
    }


}
