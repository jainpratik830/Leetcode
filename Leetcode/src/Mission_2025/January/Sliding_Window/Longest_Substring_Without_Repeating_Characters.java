package Mission_2025.January.Sliding_Window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Longest_Substring_Without_Repeating_Characters {

    public int lengthOfLongestSubstring(String s) {
        int ans =0;

        int left=0;
        int right=0;
        Set<Character> set = new HashSet<>();
        while (right<s.length()){

            char curr = s.charAt(right);

            while (left<s.length() && set.contains(curr)){
                set.remove(s.charAt(left));
                left++;
            }

            set.add(curr);
            ans =Math.max(ans,right-left+1);
            right++;

        }


        return ans;
    }

}
