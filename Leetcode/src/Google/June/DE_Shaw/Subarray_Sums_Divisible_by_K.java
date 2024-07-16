package Google.June.DE_Shaw;

import java.util.HashMap;

public class Subarray_Sums_Divisible_by_K {

    public int subarraysDivByK(int[] nums, int k) {
        int ans =0;
        HashMap<Integer,Integer> modMap = new HashMap<>();
        int prefixMod = 0;
        modMap.put(0,1);
        for (int i=0;i<nums.length;i++){
            prefixMod = (prefixMod+nums[i]%k+k)%k;
            if (modMap.containsKey(prefixMod)){
                ans+=modMap.get(prefixMod);
            }

            modMap.put(prefixMod,modMap.getOrDefault(prefixMod,0)+1);
        }

        return ans;
    }


}
