package Google.May.Others;

import java.util.ArrayList;
import java.util.List;

public class Sum_of_All_Subset_XOR_Totals {

    int ans;

    public int subsetXORSum(int[] nums) {
        ans = 0;
        generate(nums,new ArrayList<>(),0);
        return ans;
    }

    public void generate(int[] nums,List<Integer> curr,int i){
        if (i==nums.length){

            ans+= (curr.stream().reduce(0,(a,b)->(a^b)));
            return;
        }

        curr.add(nums[i]);
        generate(nums,curr,i+1);
        curr.remove(curr.size()-1);
        generate(nums,curr,i+1);
    }


}
