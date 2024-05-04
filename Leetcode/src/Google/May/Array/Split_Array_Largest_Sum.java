package Google.May.Array;

public class Split_Array_Largest_Sum {

    public int splitArray(int[] nums, int k) {

        int sum =0;
        int min = Integer.MIN_VALUE;

        for (int i:nums){
            sum+= i;
            min = Math.max(i,min);
        }

        int low = min;
        int high = sum;

        while (low<high){
            int mid = low +(high-low)/2;
            int spit = calcSplit(mid,nums);
            if (spit>k){
                low= mid+1;
            }else {
                high = mid;
            }
        }

        return low;

    }

    public int calcSplit(int sum,int[] nums){
        int curr = 0;
        int count =0;
        for(int i=0;i<nums.length;i++){
            if (curr+nums[i]>sum){
                curr= nums[i];
                count++;
            }else {
                curr+= nums[i];
            }
        }

        return count+1;
    }

}
