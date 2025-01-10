package Mission_2025.January.Arrays;

import java.util.*;

public class Group_Anagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        for (String s:strs){
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            String t =  new String(temp);
            map.putIfAbsent(t,new ArrayList<>());
            map.get(t).add(s);
        }
        for (List<String> val : map.values()){
            ans.add(val);
        }

        return ans;
    }


}
