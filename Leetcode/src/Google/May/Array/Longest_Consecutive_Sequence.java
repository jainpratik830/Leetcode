package Google.May.Array;

import java.util.HashMap;
import java.util.HashSet;

public class Longest_Consecutive_Sequence {

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i:nums){
            set.add(i);
        }
        int ans =1;
        for (int i=0;i<nums.length;i++){
            if (!set.contains(nums[i]-1)){
                int curr = nums[i];
                int count =1;
                while (set.contains(curr+1)){
                    count++;
                    curr++;
                }
                ans =Math.max(ans,count);
            }
        }


        return ans;

    }

}
