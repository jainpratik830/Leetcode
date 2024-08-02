package Google.July;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Random_Pick_Index {

    class Solution {

        int[] nums;
        HashMap<Integer, List<Integer>> map;
        Random random;

        public Solution(int[] nums) {
            this.nums=nums;
            map = new HashMap<>();
            for (int i=0;i<nums.length;i++){
                map.putIfAbsent(nums[i],new ArrayList<>());
                map.get(nums[i]).add(i);
            }
            random =new Random();
        }

        public int pick(int target) {

            List<Integer> temp = map.get(target);
            int index = random.nextInt(temp.size());

            return temp.get(index);

        }
    }



}
