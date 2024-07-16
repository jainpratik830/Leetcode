package Google.July;

import java.util.Arrays;

public class Next_Permutation  {

    public void nextPermutation(int[] nums) {
        if (nums.length==1){
            return;
        }
        int i = nums.length-2;

        while (i>=0 && nums[i+1]<=nums[i]){
            i--;
        }

        if (i<0){
            Arrays.sort(nums);
            return;
        }

        int j = nums.length-1;
        while (j>=0 && nums[j]<=nums[i]){
            j--;
        }

       swap(i,j,nums);
       reverse(i+1,nums);
    }

    public void swap(int i,int j,int[] s){
        int temp = s[i];
        s[i]=s[j];
        s[j] = temp;

    }

    public void reverse(int start,int[] s){
        int i=start;int j= s.length-1;
        while (i<j){
            swap(i,j,s);
            i++;
            j--;
        }
    }

}
