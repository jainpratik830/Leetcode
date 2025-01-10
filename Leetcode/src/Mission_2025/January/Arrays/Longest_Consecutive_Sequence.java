package Mission_2025.January.Arrays;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Longest_Consecutive_Sequence {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i:nums){
            set.add(i);
        }

        int ans =0;
        int current_streak=0;
        int curr =0;
        for (int i:set){
            if (!set.contains(i-1)){
                current_streak=1;
                curr=i;


                while (set.contains(curr+1)){
                    current_streak++;
                    curr++;
                }

                ans= Math.max(ans,current_streak);
            }
        }

        return ans;
    }

}
