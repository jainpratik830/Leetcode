package Google.March;

import java.util.*;

public class Subsequences_of_a_String_With_Maximum_Beauty {

    public int countKSubsequencesWithMaxBeauty(String s, int k) {
        int ans =0;

        Set<Character> set = new HashSet<>();
        HashMap<Character,Integer> map = new HashMap<>();
        for (char c:s.toCharArray()){
            set.add(c);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        if (set.size()<k){
            return 0;
        }

        SortedMap<Integer,List<Character>> countMap = new TreeMap<>(Collections.reverseOrder());
        for (char c: map.keySet()){
            List<Character> curr = countMap.getOrDefault(map.get(c),new ArrayList<>());
            curr.add(c);
            countMap.put(map.get(c),curr);
        }
        int k_curr =k;
        int modulo = (int) (Math.pow(10,9)+7);
        for (int currCount : countMap.keySet()){
            if (k_curr<=0){
                break;
            }
            int count_x = countMap.get(currCount).size();
            int i = Math.min(k_curr,count_x);
            ans += (int) (((combination(count_x,i)%(modulo))*(Math.pow(currCount,i)%modulo))%modulo);
            ans%= modulo;
            k_curr -= i;

        }
        return ans;
    }

    static long combination(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        }
        return combination(n - 1, k - 1) + combination(n - 1, k);
    }

}
