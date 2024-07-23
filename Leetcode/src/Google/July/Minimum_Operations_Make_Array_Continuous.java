package Google.July;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Minimum_Operations_Make_Array_Continuous {

    public int minOperations(int[] nums) {
        int n = nums.length;
        int ans = n;

        HashSet<Integer> set = new HashSet<>();
        for (int i:nums){
            set.add(i);
        }

        int[] newNums = new int[set.size()];
        int index =0;
        for (int i:set){
            newNums[index++]=i;
        }
        Arrays.sort(newNums);
        int i=0,j=0;

        while (i<newNums.length){

            while (j<newNums.length && newNums[j]-newNums[i]<n){
                j++;
            }

            int count = j-i;
            ans = Math.min(ans,n-count);
            i++;

        }

        return ans;
    }

}