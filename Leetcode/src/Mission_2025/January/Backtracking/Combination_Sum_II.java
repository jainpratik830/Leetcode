package Mission_2025.January.Backtracking;

import java.util.*;

public class Combination_Sum_II {

    List<List<Integer>> ans;

    public void generateSets(int[] nums,int i,List<Integer> curr,int target){

        if (target==0){
            ans.add(new ArrayList<>(curr));
            return;
        }



        if (i==nums.length || target<0){
            return;
        }

        for (int j=i;j<nums.length;j++){

            if (j>i && nums[j]==nums[j-1]){
                continue;
            }

            if (nums[j]>target){
                break;
            }
            curr.add(nums[j]);
            generateSets(nums,j+1,curr,target-nums[j]);
            curr.remove(curr.size()-1);
        }


    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        ans = new ArrayList<>();
        generateSets(candidates,0,new ArrayList<>(),target);
        return ans;
    }
}
