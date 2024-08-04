package Google.August;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Range_Sum_of_Sorted_Subarray_Sums {

    public  void generateSub(int index, int sum, int[] nums, List<Integer> list){

        if (index==nums.length){
            return;
        }
        list.add(sum);
        for (int i=index+1;i<nums.length;i++){
            sum+= nums[i];
            list.add(sum);
        }



    }

    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> list=new ArrayList<>();
        int Mod = (int) 1000000007;
        for (int i=0;i<n;i++){
            generateSub(i,nums[i],nums,list);
        }

        int ans =0;
        System.out.println(list);
        Collections.sort(list);
        for (int i=left-1;i<right;i++){
            ans = (ans+list.get(i))%Mod;
        }

        return ans;
    }

}
