package Google.May.Others;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Single_Number_III {

    public int[] singleNumber(int[] nums) {
        int[] ans = new int[2];
        Set<Integer> set = new HashSet<>();
        for (int i:nums){
            if (set.contains(i)){
                set.remove(i);
            }else {
                set.add(i);
            }
        }
        int k=0;
        for (int i:set){
            ans[k]=i;
            k++;
        }
        return ans;
    }

}
