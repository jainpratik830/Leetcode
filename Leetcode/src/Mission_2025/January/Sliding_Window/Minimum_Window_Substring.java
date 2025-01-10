package Mission_2025.January.Sliding_Window;

import java.util.HashMap;
import java.util.Map;

public class Minimum_Window_Substring {


    public String minWindow(String s, String t) {
        if (t.isEmpty()) return "";

        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        int have = 0, need = countT.size();
        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (countT.containsKey(c) && window.get(c).equals(countT.get(c))) {
                have++;
            }

            while (have == need) {
                if ((r - l + 1) < resLen) {
                    resLen = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }

                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar) - 1);
                if (countT.containsKey(leftChar) && window.get(leftChar) < countT.get(leftChar)) {
                    have--;
                }
                l++;
            }
        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }

    public boolean isValid(HashMap<Character,Integer> map,HashMap<Character,Integer> curr){

        for (char c:map.keySet()){
            if (!curr.containsKey(c)){
                return false;
            }
            if (curr.get(c)<map.get(c)){
                return false;
            }
        }
        return true;

    }

    public String minWindow2(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (char c:t.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        System.out.println(map);
        String ans ="";
        int left=0;
        int right =0;
        HashMap<Character,Integer> curr = new HashMap<>();
        while (right<s.length()){
            char c= s.charAt(right);
            curr.put(c,curr.getOrDefault(c,0)+1);
            System.out.println(curr);
            while (right-left+1>=t.length() && isValid(map,curr)){
                if (!ans.equals("") && right-left+1< ans.length()){
                    ans = s.substring(left,right+1);
                }
                if(ans.equals("")){
                    ans = s.substring(left,right+1);
                }
                if (curr.get(s.charAt(left))==1){
                    curr.remove(s.charAt(left));
                }else {
                    curr.put(s.charAt(left),curr.get(s.charAt(left))-1);
                }
                left++;
            }

            right++;

        }

        return ans;
    }

}
