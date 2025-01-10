package Mission_2025.January.Arrays;

import java.util.HashSet;
import java.util.Set;

public class Contains_Duplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i:nums){
            if (set.contains(i)){
                return true;
            }
            set.add(i);
        }

        return false;
    }

}
