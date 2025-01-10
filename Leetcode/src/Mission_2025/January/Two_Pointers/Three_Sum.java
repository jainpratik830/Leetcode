package Mission_2025.January.Two_Pointers;

import java.util.*;

public class Three_Sum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);


        for (int i=0;i< nums.length;i++){
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int a = nums[i];
            int left = i+1;
            int right= nums.length-1;

            while (left<right){

                int curr = a+nums[left]+nums[right];
                if (curr<0){
                    left++;
                }else if (curr>0){
                    right--;
                }else {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left<right && nums[left]==nums[left-1]){
                        left++;
                    }

                    while (left<right && nums[right]==nums[right+1]){
                        right--;
                    }
                }
            }
        }

        return ans;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();

        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i< nums.length;i++){
            map.put(nums[i],i );
        }

        for (int i=0;i< nums.length;i++){
            int a = nums[i];
            for (int j=i+1;j<nums.length;j++){
                if (map.containsKey(-1*(a+nums[j])) && map.get(-1*(a+nums[j]))!=i && map.get(-1*(a+nums[j]))!=j){
                    List<Integer> list=  new ArrayList<>();
                    list.add(a);
                    list.add(nums[j]);
                    list.add((-1*(a+nums[j])));
                    Collections.sort(list);
                    ans.add(list);
                }
            }
        }

        return ans.stream().toList();
    }

}
