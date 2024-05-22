package Google.May.Others;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    List<List<Integer>> ans;

    public void generate(int[] nums,List<Integer> curr,int i){
        if (i==nums.length){

            ans.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[i]);
        generate(nums,curr,i+1);
        curr.remove(curr.size()-1);
        generate(nums,curr,i+1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        generate(nums,new ArrayList<>(),0);
        return ans;
    }

}
