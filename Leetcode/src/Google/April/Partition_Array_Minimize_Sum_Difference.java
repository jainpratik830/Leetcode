package Google.April;

import java.util.*;

public class Partition_Array_Minimize_Sum_Difference {

    public void generateSets(List<Integer> list, HashMap<Integer,List<Integer>> sums, int i, int curr,int size){

        if (i==list.size()){
            sums.putIfAbsent(size,new ArrayList<>());
            sums.get(size).add(curr);
            return;
        }

        generateSets(list,sums,i+1,curr,size);
        generateSets(list,sums,i+1,curr+list.get(i),size+1);
    }



    public int minimumDifference(int[] nums) {

        int size = nums.length;

        int sum = Arrays.stream(nums).sum();

        List<Integer> left = new ArrayList<>();
        for (int i=0;i<size/2;i++){
            left.add(nums[i]);
        }

        List<Integer> right = new ArrayList<>();
        for (int i=size/2;i<nums.length;i++){
            right.add(nums[i]);
        }
        HashMap<Integer,List<Integer>> left_sum = new HashMap<>();
        HashMap<Integer,List<Integer>> right_sum = new HashMap<>();
        generateSets(left,left_sum,0,0,0);
        generateSets(right,right_sum,0,0,0);
        int ans = Integer.MAX_VALUE;
        for (int i=0;i<size/2;i++){

            List<Integer> curr_left = left_sum.getOrDefault(i,new ArrayList<>());
            List<Integer> curr_right = right_sum.getOrDefault(size/2-i,new ArrayList<>());
            Collections.sort(curr_right);

            for (int j:curr_left){

                int start = 0;
                int end = curr_right.size()-1;

                while (start<=end){
                    int mid = (start+end)/2;
                    int target = 2* (j+curr_right.get(mid));
                    if (sum==target){
                        return 0;
                    }else if (sum>target){
                        start=mid+1;
                    }else {
                        end = mid -1;
                    }

                }

                if (start<curr_right.size()){
                    ans = Math.min(ans,Math.abs(sum- 2* (j+curr_right.get(start))));
                }
                if (end>=0){
                    ans = Math.min(ans,Math.abs(sum- 2* (j+curr_right.get(end))));
                }
            }
        }



        return ans;
    }

}
