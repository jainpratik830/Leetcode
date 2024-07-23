package Google.July;

import java.util.*;

public class Longest_String_Chain {

    public int longestStrChain(String[] words) {

        HashMap<String,Integer> map= new HashMap<>();
        Set<String> set = new HashSet<>();
        for (String s:words){
            set.add(s);
            map.put(s,1);
        }

        Arrays.sort(words, Comparator.comparingInt(w->w.length()));
        for (int i=words.length-1;i>=0;i--){
            String curr = words[i];
            for (int j=0;j<words[i].length();j++){
                String temp = curr.substring(0,j)+curr.substring(j+1);
                if (map.containsKey(temp)){
                    map.put(temp,Math.max(map.get(temp),map.get(curr)+1));
                }
            }
        }

        int ans =0;
        for (String i:map.keySet()){
            ans = Math.max(ans,map.get(i));
        }

        return ans;
    }

}
