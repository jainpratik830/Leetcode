package Google.July;

import java.util.HashMap;
import java.util.HashSet;

public class Number_of_Good_Ways_to_Split_a_String {

    public int numSplits(String s) {
        int ans =0;

        HashMap<Character,Integer> map = new HashMap<>();
        for (Character c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        HashSet<Character> set = new HashSet<>();

        for (int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            set.add(curr);
            int count = map.getOrDefault(curr,0);
            if (count==1){
                map.remove(curr);
            }else if (count>1){
                map.put(curr,count-1);
            }

            ans += (map.keySet().size()== set.size()) ? 1: 0;
        }

        return ans;
    }


}
