package Google.July;

import java.util.HashMap;

public class Minimum_Window_Substring {

    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        int[] ans = new int[3];
        ans[0]=-1;
        HashMap<Character,Integer> map = new HashMap<>();
        for (char c:t.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        int uniqueChars = map.size();

        int left = 0;
        int right =0;
        int formed = 0;
        HashMap<Character,Integer> windowMap = new HashMap<>();
        while (right<s.length())
        {
            char curr = s.charAt(right);
            windowMap.put(curr,windowMap.getOrDefault(curr,0)+1);

            if (map.containsKey(curr) && map.get(curr).intValue()==windowMap.get(curr).intValue()){
                formed++;
            }

            while (left<=right && formed==uniqueChars){

                char leftChar = s.charAt(left);
                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }
                windowMap.put(leftChar,windowMap.get(leftChar)-1);
                if (map.containsKey(leftChar) && map.get(leftChar).intValue()> windowMap.get(leftChar).intValue()){
                    formed--;
                }

                left++;

            }

            right++;
        }

        return ans[0]==-1? "" : s.substring(ans[1],ans[2]+1);
    }

}
