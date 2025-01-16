package Mission_2025.January.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combination_Sum {

    List<List<Integer>> ans;

    public void generateSets(int[] nums,int i,List<Integer> curr,int target){

        if (target==0){
            ans.add(new ArrayList<>(curr));
            return;
        }



        if (i==nums.length || target<0){
            return;
        }

        curr.add(nums[i]);
        generateSets(nums,i,curr,target-nums[i]);
        curr.remove(curr.size()-1);
        generateSets(nums,i+1,curr,target);

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        generateSets(candidates,0,new ArrayList<>(),target);
        return ans;
    }

}
