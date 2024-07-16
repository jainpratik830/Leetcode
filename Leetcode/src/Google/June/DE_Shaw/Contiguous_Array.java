package Google.June.DE_Shaw;

import java.util.HashMap;

public class Contiguous_Array {

    public int findMaxLength(int[] nums) {
        int ans =0;
        HashMap<Integer,Integer> zeroCount = new HashMap<>();
        zeroCount.put(0,-1);
        int sum =0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==0){
               sum  +=-1;
            }else{
                sum+=1;
            }
            if (zeroCount.containsKey(sum)){
                ans = Math.max(ans,i-zeroCount.get(sum));
            }else {
                zeroCount.put(sum,i);
            }
        }


        return ans;
    }

}
