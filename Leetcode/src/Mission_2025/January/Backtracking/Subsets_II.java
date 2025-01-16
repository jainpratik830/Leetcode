package Mission_2025.January.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_II {

    List<List<Integer>> ans;

    public void generateSets(int[] nums,int i,List<Integer> curr){

        ans.add(new ArrayList<>(curr));
        for (int j=i;j<nums.length;j++){

            if (j>i && nums[j]==nums[j-1]){
                continue;
            }

            curr.add(nums[j]);
            generateSets(nums,j+1,curr);
            curr.remove(curr.size()-1);
        }

    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        ans = new ArrayList<>();
        generateSets(nums,0,new ArrayList<>());
        return ans;
    }

}
