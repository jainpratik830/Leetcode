package Google.June.DE_Shaw;

import java.util.HashMap;

public class Number_of_Wonderful_Substrings {

    public long wonderfulSubstrings(String word) {
        long ans  =0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int mask =0;
        map.put(0, 1);
        for (int i=0;i<word.length();i++){

            int curr = word.charAt(i)-'a';
            mask ^= (1<<curr);

            ans += map.getOrDefault(mask,0);
            map.put(mask,map.getOrDefault(mask,0)+1);

            for (int j=0;j<10;j++){
                ans += map.getOrDefault(mask ^ (1<<j),0);
            }
        }

        return ans;
    }


}
