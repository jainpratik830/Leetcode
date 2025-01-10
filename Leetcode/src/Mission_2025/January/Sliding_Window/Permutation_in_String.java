package Mission_2025.January.Sliding_Window;

import java.util.Arrays;
import java.util.HashMap;

public class Permutation_in_String {

    public boolean checkInclusion(String s1, String s2) {
        int[] map = new int[26];
        for (char c:s1.toCharArray()){
            map[c-'a']++;
        }

        int left =0;
        int right =0;
        int [] curr = new int[26];
        while (right<s2.length()){
            int currChar = s2.charAt(right)-'a';
            curr[currChar]++;
            while (curr[currChar]> map[currChar]){
                curr[s2.charAt(left)-'a']--;
                left++;
            }
            if (right-left+1==s1.length()){
                return true;
            }
            right++;

        }

        return false;

    }

}
