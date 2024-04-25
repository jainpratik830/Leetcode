package Google.April;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Closest_Subsequence_Sum {

    public void generateSets(List<Integer> list,List<Integer> sums,int i,int curr){

        if (i==list.size()){
            sums.add(curr);
            return;
        }

        generateSets(list,sums,i+1,curr);
        generateSets(list,sums,i+1,curr+list.get(i));
    }

    public int search(List<Integer> list,int target){
        int low = 0;
        int high = list.size();

        while (low<high){
            int mid = (low+high)/2;

            if (list.get(mid)>=target){
                high = mid;
            }else {
                low = mid+1;
            }

        }

        return list.get(low>=list.size() ?list.size()-1 : low );
    }

    public int getMinVal(List<Integer> leftSum, List<Integer> rightSum, int tar){


        // This function uses two pointer Approach

        // invoke a min having max int value
        int min = Integer.MAX_VALUE;

        // i - index for left array
        int i = 0;

        // j - index for right array
        int j = rightSum.size()-1;


        while(i<leftSum.size()&&j>=0){
            int sum = leftSum.get(i)+rightSum.get(j);
            min = Math.min(min,Math.abs(tar-sum));

            // if sum is less then target we need to increase sum
            // we will increase index of left array as the left array is sorted
            // by increasing we can get larger values
            if(sum<tar){
                i++;
            }
            // Similarly if sum > tar; decrease j to get smaller values;
            else if(sum >tar){
                j--;
            }
            // if sum == tar; it's the min diff; so return 0;
            else{
                return 0;
            }
        }
        return min;
    }

    public int minAbsDifference(int[] nums, int goal) {

        int size = (nums.length+1)/2;
        List<Integer> left = new ArrayList<>();
        for (int i=0;i<size;i++){
            left.add(nums[i]);
        }

        List<Integer> right = new ArrayList<>();
        for (int i=size;i<nums.length;i++){
            right.add(nums[i]);
        }
        List<Integer> left_sum = new ArrayList<>();
        List<Integer> right_sum = new ArrayList<>();
        generateSets(left,left_sum,0,0);
        generateSets(right,right_sum,0,0);
        Collections.sort(left_sum);
        Collections.sort(right_sum);
        int ans = Integer.MIN_VALUE;
//        for (int i:left_sum){
//            ans = Math.min(ans ,Math.abs(goal-(i+search(right_sum,goal-i))));
//        }

        return getMinVal(left_sum,right_sum,goal);


    }



}
