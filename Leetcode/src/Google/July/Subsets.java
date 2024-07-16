package Google.July;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    List<List<Integer>> ans;

    public void generate(int i,List<Integer> curr,int[] nums){
        if (i== nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }

        // for (int j=i;j<nums.length;j++){
        curr.add(nums[i]);
        generate(i+1,curr,nums);
        curr.remove(curr.size()-1);
        generate(i+1,curr,nums);
        // }
    }

    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        generate(0,new ArrayList<>(),nums);
        return ans;
    }

}
