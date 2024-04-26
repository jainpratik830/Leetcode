package Google.April;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Four_Sum {

    List<List<Integer>> ans;

    public void  kSum(int i,long target,List<Integer> curr,int k,int[] nums){

        if (k==2){
            int low = i;
            int high = nums.length-1;
            while (low<high){
                if (nums[low]+nums[high]==target){
                    curr.add(nums[low]);
                    curr.add(nums[high]);
                    ans.add(new ArrayList<>(curr));
                    curr.remove(curr.size()-1);
                    curr.remove(curr.size()-1);
                    low++;
                    while (low<high && nums[low]==nums[low-1]){
                        low++;
                    }
                }
                else if (nums[low]+nums[high]<target){
                    low++;
                }else {
                    high--;
                }
            }
            return;
        }

        for (int j=i;j< nums.length-k+1;j++){

            if (j>i && nums[j]==nums[j-1]){
                continue;
            }
            curr.add(nums[j]);
            kSum(j+1,target-nums[j],curr,k-1,nums);
            curr.remove(curr.size()-1);

        }



    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        ans = new ArrayList<>();
        Arrays.sort(nums);
        kSum(0,target,new ArrayList<>(),4,nums);
        return ans;
    }

}
