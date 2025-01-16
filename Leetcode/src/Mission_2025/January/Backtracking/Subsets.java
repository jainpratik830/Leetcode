package Mission_2025.January.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    List<List<Integer>> ans;

    public void generateSets(int[] nums,int i,List<Integer> curr){

        if (i==nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[i]);
        generateSets(nums,i+1,curr);
        curr.remove(curr.size()-1);
        generateSets(nums,i+1,curr);

    }

    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        generateSets(nums,0,new ArrayList<>());
        return ans;
    }

}
