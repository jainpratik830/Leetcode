package Google.July;

import java.util.HashMap;

public class Count_Subarrays_With_Median_K {

    public int countSubarrays(int[] nums, int k) {

        int sum = 0;
        int index = -1;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==k){
                index=i;
            }
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=index;i<nums.length;i++){
            sum += (nums[i]==k? 0 : (nums[i]>k ? 1 : -1));
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        // System.out.println(map);
        int ans =0;
        sum =0;
        for (int i=index;i>=0;i--){
            sum += (nums[i]==k? 0 : (nums[i]>k ? 1 : -1));
            ans+= map.getOrDefault(0-sum,0);
            ans+= map.getOrDefault(1-sum,0);
        }
        return ans;
    }

}
