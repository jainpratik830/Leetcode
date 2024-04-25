package Google.April;

import java.util.HashSet;

public class Longest_Substring_Without_Repeating_Characters {

    public int lengthOfLongestSubstring(String s) {
        int ans =0;
        HashSet<Character> set = new HashSet<>();
        int start =0;
        int end = 0;
        while (start<s.length() && end <s.length() ){

            if (set.contains(s.charAt(end))){
                while (s.charAt(start)!=s.charAt(end)){
                    set.remove(s.charAt(start));
                    start++;

                }
                start++;

            }else {
                set.add(s.charAt(end));
            }

            end++;
            ans = Math.max(ans,end-start+1);

        }

        return ans;
    }

}
