package Google.July;

import java.util.HashMap;

public class Subarrays_with_K_Different_Integers {

    public int subarraysWithKDistinct(int[] nums, int k) {
        int uptoK = slidingWindow(nums,k);
        int uptoK1 = slidingWindow(nums,k-1);
        // System.out.println(uptoK);
        return uptoK-uptoK1;
    }

    public int slidingWindow(int[] nums,int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        int left =0;
        int right =0;
        int ans =0;

        while (right<nums.length){
            int curr = nums[right];
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            while (map.size()>k){

                if (map.get(nums[left])==1){
                    map.remove(nums[left]);
                }else {
                    map.put(nums[left],map.get(nums[left])-1);

                }
                left++;
            }
            ans += right-left+1;
            right++;

        }
        return ans;
    }

}
