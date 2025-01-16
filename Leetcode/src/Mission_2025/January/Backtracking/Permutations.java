package Mission_2025.January.Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {
    List<List<Integer>> ans;

    public void generateSets(int[] nums, List<Integer> curr, Set<Integer> currSet){

        if (currSet.size()==nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int j=0;j<nums.length;j++){
            if (currSet.contains(nums[j])){
                continue;
            }
            curr.add(nums[j]);
            currSet.add(nums[j]);
            generateSets(nums,curr,currSet);
            curr.remove(curr.size()-1);
            currSet.remove(nums[j]);
        }


    }

    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        generateSets(nums,new ArrayList<Integer>(),new HashSet<Integer>());
        return ans;
    }

}
