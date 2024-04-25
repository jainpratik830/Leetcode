package Google.April;

import java.util.HashMap;

public class Length_of_Longest_Subarray_Most_K_Frequency {

    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap();
        int left =0;
        int right =0;
        int ans =0;
        while (left<nums.length && right<nums.length){

            int curr = nums[right];
            if (map.getOrDefault(curr,0)+1>k){
                while (nums[left]!=curr){
                    map.put(nums[left],map.get(nums[left])-1);
                    left++;
                }
                left++;
                map.put(curr,map.getOrDefault(curr,0)-1);
            }else{
                map.put(curr,map.getOrDefault(curr,0)+1);
                ans = Math.max(ans,right-left+1);
                right++;
            }
        }
        return ans;

    }

}
