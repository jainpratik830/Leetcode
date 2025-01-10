package Mission_2025.January.Sliding_Window;

import java.util.Arrays;

public class Longest_Repeating_Character_Replacement {



    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left =0;
        int right =0;
        int ans =0;
        int max=0;
        while (right<s.length()){

            int curr = s.charAt(right)-'A';
            count[curr]++;

// Here we do not update max when moving the winow because max is not the max frequency in the current window, it represents the overall max frequency seen
// till now in all the windows and the window never actually shrinks, it always moves on to the right or increases, and the value of max is also updated
            max= Math.max(count[curr],max);
            if (right-left+1 - max>k){
                while (left< s.length() && (right-left+1 - max)>k){
                    count[s.charAt(left)-'A']--;

                    left++;
                }
            }else {
                ans = Math.max(right-left+1,ans);

            }
            right++;

        }

        return ans;
    }

}
