package Mission_2025.January.Binary_Search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Longest_Increasing_Subsequence {

    public int lengthOfLIS(int[] nums) {
        int ans =1;
        List<Integer> sorted= new ArrayList<>();
        for (int i:nums){

            if (sorted.isEmpty() || sorted.get(sorted.size()-1)<i){
                sorted.add(i);
                ans = Math.max(sorted.size(),ans);
                continue;
            }

            int index=  search(sorted,i);
            sorted.set(index,i);

        }

        return ans;

    }

    public int search(List<Integer> list,int num){

        int low = 0;
        int high = list.size()-1;
        // System.out.println("List="+list+" num="+num);
        while (low<high){

            // System.out.println("Low="+low+" high="+high);
            int mid = (low+high)/2;
            if (list.get(mid)<num){
                low=  mid+1;
            }else {
                high=mid;
            }
        }

        return low;

    }

}
