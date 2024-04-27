package Google.April;

import java.util.Random;

public class Kth_Smallest_Element {

    public int findKthSmallest(int[] nums, int k) {
        int n = nums.length;
        return quickselect(0, n - 1, k - 1, nums);
    }

    public int quickselect(int start,int end,int k,int[] nums){

        if (start==end){
            return start;
        }

        int pivot_index= partition(start,end,nums);

        if (k==pivot_index){
            return nums[pivot_index];
        }else if(k<pivot_index){
            return quickselect(start,pivot_index-1,k,nums);
        }else {
            return quickselect(pivot_index+1,end,k,nums);
        }
    }

    public int partition(int start,int end,int[] nums){
        Random random =new Random();

        int index = start+ random.nextInt(end-start);
        int num_index = nums[index];
        swap(nums,num_index,end);

        int i = start;
        for (int j=start;j<end;j++){
            if (nums[j]<nums[end]){
                swap(nums,j,i);
                i++;
            }

        }
        swap(nums,i,end);
        return i;

    }

    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i]= nums[j];
        nums[j]=temp;
    }

}
